package ec.edu.espe.plantillaEspe.config.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OpaqueSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {

        http.cors(Customizer.withDefaults());
        http.authorizeHttpRequests(request -> {
            request.requestMatchers(HttpMethod.GET,
                            "/public/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/apiGeneral-docs/**", "swagger-ui-GeneralApi/**", "/swagger-ui-GeneralApi.html/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/public/**").permitAll()
                    .anyRequest().authenticated();
        });
        http.oauth2ResourceServer(c -> c.opaqueToken(Customizer.withDefaults()));
        return http.build();
    }

    @Bean
    OpaqueTokenIntrospector tokenIntrospector(RestTemplateBuilder builder, OAuth2ResourceServerProperties resourceServerProps) {
        return new CustomOpaqueTokenIntrospector(builder, resourceServerProps);
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors();
//        http
//                .authorizeRequests(authz -> authz
//                        .antMatchers(HttpMethod.GET, "/public/**").permitAll()
//                        .antMatchers(HttpMethod.POST, "/public/**").permitAll()
//                        .anyRequest().authenticated())
//                .oauth2ResourceServer().opaqueToken();
//
//        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }
}
