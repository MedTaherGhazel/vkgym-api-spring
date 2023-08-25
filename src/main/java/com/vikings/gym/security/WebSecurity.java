package com.vikings.gym.security;

import com.vikings.gym.model.Role;
import com.vikings.gym.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurity {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
////    private RsakeysConfig rsakeysConfig;
    @Value("${authentication.internal-api-key}")
    private String internalApiKey;

//    public WebSecurity(RsakeysConfig rsakeysConfig, PasswordEncoder passwordEncoder) {
//        this.rsakeysConfig = rsakeysConfig;
//        this.passwordEncoder = passwordEncoder;
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

                http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/authentication/**").permitAll()
                        .requestMatchers("/api/program").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/program").permitAll()
                        .requestMatchers("/api/program").hasRole(Role.ADMIN.name())
                        .requestMatchers("/api/internal/**").permitAll()
                        .anyRequest().authenticated());

                //jwt filter
                http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
                return http.build();
    }
    @Bean
    public InternalApiAuthenticationFilter internalApiAuthenticationFilter(){
        return new InternalApiAuthenticationFilter(internalApiKey);
    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){}
    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(){
        return new JwtAuthorizationFilter();
    }
@Bean
public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }

}