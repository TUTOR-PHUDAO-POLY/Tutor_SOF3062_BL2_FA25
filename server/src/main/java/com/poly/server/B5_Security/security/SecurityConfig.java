package com.poly.server.B5_Security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // mat khau se duoc ma hoa => Bcrypt

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // fix cung gia tri => inmemory
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Tao ra cac doi tuong UserDetail
        // B1: Fake data cho UserDetails
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build();
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http
                // check authen va phan quyen nguoi dung tai day
                .csrf(s -> s.disable()) // doi vs test trinh local => tat thang nay di
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // AI CUNG TRUY CAP DUOC
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // CHI ADMIN MOI TRUY CAP DUOC
                        .requestMatchers("/api/user/**").hasRole("USER")// CHI USER MOI TRUY CAP DUOC
                        .anyRequest().authenticated() // cac request con lai chi authen thoi
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
