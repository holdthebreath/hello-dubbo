package helloworld;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "helloworld.dao")
public class HelloWorldProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldProviderApplication.class, args);
        log.info("ProviderApplication start!");
    }

}
