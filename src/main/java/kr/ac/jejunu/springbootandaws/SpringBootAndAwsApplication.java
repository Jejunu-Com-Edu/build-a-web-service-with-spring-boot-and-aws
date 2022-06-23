package kr.ac.jejunu.springbootandaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootAndAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndAwsApplication.class, args);
    }

}
