package com.porcporc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/**","/login", "/register", "/editUser/*","/api/**", "/css/**")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/view-products/**");
 //               .hasRole("ADMIN");
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
//        http.httpBasic();
//        http.formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login-submit")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/");
 //               .failureUrl("/login-error");
        http.logout().logoutUrl("/logout").permitAll();
    }





    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
