package com.example.automation.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                /*.antMatchers("/userView/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/automationRuleView/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/deviceView/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/logView/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/sensorTypeView/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/sensorView/**").hasAnyAuthority("ADMIN","USER")*/

                .antMatchers("/userView/delete/**").hasAnyAuthority("ADMIN")
                .antMatchers("/userView/edit/**").hasAnyAuthority("ADMIN")

                .antMatchers("/automationRuleView/create/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/automationRuleView/delete/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/automationRuleView/edit/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/deviceView/create/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/deviceView/delete/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/deviceView/edit/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/logView/create/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/logView/delete/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/logView/edit/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/sensorTypeView/create/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/sensorTypeView/delete/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/sensorTypeView/edit/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/sensorView/create/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/sensorView/delete/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/sensorView/edit/**").hasAnyAuthority("ADMIN", "USER")
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