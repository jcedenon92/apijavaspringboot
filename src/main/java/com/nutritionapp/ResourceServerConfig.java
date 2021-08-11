package com.nutritionapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
    private ResourceServerTokenServices tokenServices;
	
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .exceptionHandling().authenticationEntryPoint(new AuthException())
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**" ).permitAll()
                .antMatchers("/alimentos/**" ).permitAll()                
                .antMatchers("/controles/**" ).permitAll()
                .antMatchers("/dias/**" ).permitAll()
                .antMatchers("/dosis/**" ).permitAll()
                .antMatchers("/grupos/**" ).permitAll()
                .antMatchers("/pacientes/**" ).permitAll()
                .antMatchers("/planes/**" ).permitAll()
                .antMatchers("/predicciones/**" ).permitAll()
                .antMatchers("/roles/**" ).permitAll()
                .antMatchers("/turnos/**" ).permitAll()
                .antMatchers("/vacunas/**" ).permitAll()
                .antMatchers("/tokens/**" ).permitAll()
                .antMatchers("/usuarios/**" ).permitAll();
                
                
    }    

}
