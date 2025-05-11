package com.cineuniverse.grupo1.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cineuniverse.grupo1.models.Usuarios;
import com.cineuniverse.grupo1.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        private UsuarioRepository usuarioRepository;

        @Autowired
        public SecurityConfiguration(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        }

        @Bean
        public UserDetailsService userDetailsService() {
                return username -> {
                        Usuarios usuario = usuarioRepository.findByDni(username)
                                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con DNI: " + username));
                        return new UsuarioPrincipal(usuario); // Devuelve UsuarioPrincipal
                };
        }
        
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.requestCache((cache) -> cache.requestCache(new NullRequestCache())) // Deshabilita la "saved request"
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/home","/peliculas/{id}","/peliculas/listarPeliculas","/dulceria/{id}","/dulceria/listarProductos","/peliculas/insertarPeliculas","/registro/usuario","/tarjetas/nueva","/tarjetas/guardar", "/css/**", "/js/**","/img/**","/resources/**","/mdbootstrap/**").permitAll() // Permite acceso sin autenticación a la página de inicio u otros archivos.
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
                )
                .formLogin((form) -> form
                        .loginPage("/loginUsuario") // Especifica tu página de login personalizada (opcional)
                        .defaultSuccessUrl("/home") // Redirige al usuario autenticado a la página principal
                        .permitAll() // Permite acceso a la página de login a todos
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL para cerrar sesión
                        .logoutSuccessUrl("/loginUsuario?logout") // Redirige después de cerrar sesión
                        .permitAll()
                );

        return http.build();
        }

}
