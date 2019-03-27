package br.com.geduca.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Configuração do Spring Security - AuthorizationServerConfigurerAdapter
 * Não necessita estar autenticado para executar requisição em '/teste', mas pra frente configurar healthcheck
 * API REST não criará sessão no servidor, ou seja, não manterá estado de nada.
 * Cross site desabilitado -> javascript injection
 *
 * @author gustavoclay
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("geduca")
			.secret("{noop}g&duc@")
			.scopes("read", "write")
			.authorizedGrantTypes("password")
			.accessTokenValiditySeconds(1800);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.authenticationManager(authenticationManager);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}
