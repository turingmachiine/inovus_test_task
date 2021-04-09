package ru.bvb.inovus_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import ru.bvb.inovus_generator.models.CarNumber;

import java.util.Random;

@SpringBootApplication
public class InovusGeneratorApplication {

    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_APPLICATION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CarNumber carNumber() {
        return new CarNumber();
    }

    public static void main(String[] args) {
        SpringApplication.run(InovusGeneratorApplication.class, args);
    }

}
