package bsnt.np.security;

import bsnt.np.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {
    private final UserService userService;

    public WebSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return   httpSecurity.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("admin")
                        .requestMatchers("/staff/**").hasAnyAuthority("admin","staff")
                        .anyRequest().authenticated())
                .userDetailsService(userService).build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
