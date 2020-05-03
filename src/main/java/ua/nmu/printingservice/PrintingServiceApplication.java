package ua.nmu.printingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class PrintingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrintingServiceApplication.class, args);
    }

}
