package project.com.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
    @Value("${spring.h2.console.enabled:false}")
    private boolean h2ConsoleEnabled;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (h2ConsoleEnabled)
            http.authorizeRequests()
                    .antMatchers("/h2", "/h2/**").permitAll()
                    .and()
                    .headers().frameOptions().sameOrigin();

        http
                .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring().antMatchers("/resources/**");
    }
}