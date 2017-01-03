package com.cuisine_mart.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Rajiv on 8/25/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//    @Autowired
//    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DataSource dataSource;

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
        .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/dashboard").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/order/address").hasRole("USER")
                .antMatchers("/restaurant/**").permitAll()
                .antMatchers("/rest/cart/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/cart/**").permitAll()
                .antMatchers("/rest/**").permitAll()
                .antMatchers("/","/**").permitAll()
//                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/handleLogin")
                .usernameParameter("username").passwordParameter("password")
//                .loginPage("/login").successForwardUrl("/login/handleLogin")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout").logoutUrl("/j_spring_security_logout")
                .permitAll().and().sessionManagement().invalidSessionUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }
}
