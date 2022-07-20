package elevuslabs.app.endereco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class CepFeignConfig {

    @Value("${api.cep.username}")
    private String username;

    @Value("${api.cep.password}")
    private String password;

    private BasicAuthenticationInterceptor basicAuthenticationInterceptor;

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
        return new BasicAuthenticationInterceptor(username, password);
    }
}
