package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloDubboConsumerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloDubboConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloDubboConsumerApplication.class, args);
		LOGGER.info("ConsumerApplication start!");
	}

}
