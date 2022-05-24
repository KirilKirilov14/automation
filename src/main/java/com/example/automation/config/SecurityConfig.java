package com.example.automation.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/аpi/device/postSensorData", "/ignore2");
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             /*   .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
                .and()*/
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/userView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/automationRuleView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/deviceView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/logView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/sensorTypeView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/sensorView/**").hasAnyAuthority("ADMIN")
                /*.anyRequest().permitAll()*/
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}