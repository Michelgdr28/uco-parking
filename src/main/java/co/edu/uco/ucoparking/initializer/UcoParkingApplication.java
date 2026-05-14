package co.edu.uco.ucoparking.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "co.edu.uco.ucoparking")
@EnableJpaRepositories(
    basePackages = "co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa"
)
public class UcoParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcoParkingApplication.class, args);
    }
}