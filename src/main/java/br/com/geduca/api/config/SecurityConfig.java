package br.com.geduca.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuração do Spring Security - WebSecurityConfigurerAdapter
 * A anotação ResourceServerConfigurerAdapter gera um WebSecurityConfigurerAdapter.
 * A Order do WebSecurityConfigurerAdapter gerado pelo ResourceServerConfigurerAdapter é 3.
 * A Order deste WebSecurityConfigurerAdapter deve ser > 3, para que o configure(HttpSecurity http) do
 * ResourceServerConfig tenha precedência sobre o configure(HttpSecurity http) do SecurityConfig.
 *
 * @author gustavoclay
 *
 */
@Configuration
@EnableWebSecurity
@Order(4)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin")
		.roles("ROLE");
	}
	
	@Bean
	@Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
