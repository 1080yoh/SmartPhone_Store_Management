package giaodienchuan.model.BackEnd.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("giaodienchuan.model.BackEnd.*")
@EnableAutoConfiguration
public class AppConfig {
}
