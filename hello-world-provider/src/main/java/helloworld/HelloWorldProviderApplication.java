package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldProviderApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldProviderApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldProviderApplication.class, args);
        LOGGER.info("ProviderApplication start!");
    }

}
