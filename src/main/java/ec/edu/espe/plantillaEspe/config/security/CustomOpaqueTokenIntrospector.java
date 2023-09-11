package ec.edu.espe.plantillaEspe.config.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.web.client.RestOperations;

import java.time.Duration;


public class CustomOpaqueTokenIntrospector implements OpaqueTokenIntrospector {
    private OAuth2ResourceServerProperties.Opaquetoken opaqueTokenProps;
    private RestTemplateBuilder builder;
    CustomOpaqueTokenIntrospector(RestTemplateBuilder builder, OAuth2ResourceServerProperties resourceServerProps) {
        this.opaqueTokenProps = resourceServerProps.getOpaquetoken();
        this.builder = builder;
    }

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
      //  System.out.println(token);
        RestOperations restOperations = builder
                .defaultHeader("Authorization", "Bearer " + token)
                .setConnectTimeout(Duration.ofSeconds(60))
                .setReadTimeout(Duration.ofSeconds(60))
                .build();
        return new NimbusOpaqueTokenIntrospector(opaqueTokenProps.getIntrospectionUri(), restOperations).introspect(token);
    }
}
