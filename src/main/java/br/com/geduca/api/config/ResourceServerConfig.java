package br.com.geduca.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Configuração do Spring Security - ResourceServerConfigurerAdapter
 * Não necessita estar autenticado para executar requisição em '/teste', mas pra frente configurar healthcheck
 * API REST não criará sessão no servidor, ou seja, não manterá estado de nada.
 * Cross site desabilitado -> javascript injection
 * Configuração do CORS de acordo com a documentação do Spring, Em caso de problemas
 * implmentar o filtro com as configurações do CORS
 *
 * @author gustavoclay
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{
	
	private String originPermitida = "http://localhost:4200"; // TODO: Configurar para diferentes ambientes
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/teste").permitAll()
        .anyRequest().authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().csrf().disable()
        .cors();
	}
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.stateless(true);
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(originPermitida));
		configuration.setAllowedMethods(Arrays.asList("GET, POST, PUT, DELETE, OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Authorization, Content-Type, Accept, X-Requested-With, charset"));
		configuration.setExposedHeaders(Arrays.asList("Content-Disposition"));
		configuration.setMaxAge((long) 3600);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
}
