import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/").permitAll() // Allow GET requests to the root path
                .requestMatchers(HttpMethod.GET, "/login").permitAll() // Allow GET requests to the login page
                .requestMatchers(HttpMethod.POST, "/register").permitAll() // Allow POST requests to the register page
                .requestMatchers(HttpMethod.GET, "/principal/register").permitAll() // Allow GET requests to the principal/register page
                .requestMatchers(HttpMethod.GET, "/principal/menu").permitAll() // Allow GET requests to the principal/menu page
                .anyRequest().authenticated() // All other paths require authentication
                .and()
                .formLogin()
                .loginPage("/login") // Use your login page
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }
}