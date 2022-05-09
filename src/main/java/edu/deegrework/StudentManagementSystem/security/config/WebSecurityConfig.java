package edu.deegrework.StudentManagementSystem.security.config;

import edu.deegrework.StudentManagementSystem.security.CustomUserDetailsService;
import edu.deegrework.StudentManagementSystem.security.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
//                .antMatchers("/v*/**").permitAll()
                .antMatchers(HttpMethod.GET, "/v*/teachers/**").hasAnyAuthority(Role.TEACHER.name(), Role.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/v*/students/**").hasAnyAuthority(Role.STUDENT.name(), Role.ADMIN.name())
                .antMatchers("/v*/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/logout").permitAll()

//                .anyRequest().hasAuthority(Role.ADMIN.name());
//                .antMatchers("/v*/**")
//                .hasAuthority("ADMIN")
//                .anyRequest().permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
                .defaultSuccessUrl("/successLogin", true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(encoder);
        return provider;
    }
}
