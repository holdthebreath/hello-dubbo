package hellodubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloDubboProviderApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloDubboProviderApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(HelloDubboProviderApplication.class, args);
        LOGGER.info("ProviderApplication start!");
    }

}
