package com.saraf.myapp.security;

import com.saraf.myapp.security.filter.AuthenticationFilter;
import com.saraf.myapp.security.filter.ExceptionHandlerFilter;
import com.saraf.myapp.security.filter.JWTAuthorizationFilter;
import com.saraf.myapp.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;
    private CustomAuthenticationManager customAuthenticationManager;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");

        http
                 .csrf().disable()
                 .authorizeHttpRequests()
                 .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                 .addFilter(authenticationFilter)
                 .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

         return http.build();
    }

//    @Bean
//    public UserDetailsService users(){
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("user-pass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
