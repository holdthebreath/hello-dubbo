package helloworld;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@Slf4j
@ServletComponentScan
public class HelloWorldConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldConsumerApplication.class, args);
        log.info("ConsumerApplication start!");
    }

}
