package edu.deegrework.StudentManagementSystem.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic();
//                .and()
//                .authorizeRequests()
////                .antMatchers("/v*/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/v*/teachers/**")
//                    .hasAnyAuthority(Role.TEACHER.name(), Role.ADMIN.name())
//                .antMatchers(HttpMethod.GET, "/v*/students/**")
//                    .hasAnyAuthority(Role.STUDENT.name(), Role.TEACHER.name(), Role.ADMIN.name())
//                .antMatchers("/v*/**")
//                    .hasAuthority(Role.ADMIN.name())
//                .antMatchers("/login", "/logout").permitAll()
//                .anyRequest().authenticated();      // <-lt

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        return auth
                .authenticationProvider(daoAuthenticationProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(encoder);
        return provider;
    }
}
