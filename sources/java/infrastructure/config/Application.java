package infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = {"access", "infrastructure.config", "infrastructure.bootstrap", "schedule"})
@PropertySources({@PropertySource(value = "flyway.properties", encoding = "UTF-8")})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}