package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldConsumerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldConsumerApplication.class, args);
		LOGGER.info("ConsumerApplication start!");
	}

}
