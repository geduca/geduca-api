package br.com.geduca.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Configuração do Spring Security - ResourceServerConfigurerAdapter
 * Não necessita estar autenticado para executar requisição em '/teste', mas pra frente configurar healthcheck
 * API REST não criará sessão no servidor, ou seja, não manterá estado de nada.
 * Cross site desabilitado -> javascript injection
 *
 * @author gustavoclay
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/teste").permitAll()
        .anyRequest().authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().csrf().disable();
	}
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.stateless(true);
    }
	
}
