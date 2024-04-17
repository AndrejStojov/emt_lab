//package com.example.lab1emt.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig{
//
//    private final PasswordEncoder passwordEncoder;
//
//    public SecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests( (requests) -> requests
//                        .anyRequest()
//                        .hasAnyRole( "User", "Librarian")
//                )
//                .formLogin((form) -> form
//                        .permitAll()
//                        .failureUrl("/login?error=BadCredentials")
//                        .defaultSuccessUrl("/books", true)
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/login")
//                )
//                .exceptionHandling((ex) -> ex
//                        .accessDeniedPage("/access_denied")
//                );
//
//        return http.build();
//    }
//
//
//    //     In Memory Authentication
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails librarian1 = User.builder()
//                .username("librarian1")
//                .password(passwordEncoder.encode("librarian1"))
//                .roles("Librarian")
//                .build();
//
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password(passwordEncoder.encode("user1"))
//                .roles("User")
//                .build();
//
//        return new InMemoryUserDetailsManager(librarian1, user1);
//    }
//
//}