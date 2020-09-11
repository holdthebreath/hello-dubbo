package helloworld.service.impl;

import helloworld.domain.HelloWorld;
import helloworld.service.HelloWorldService;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

/**
 * @ClassName HelloWorldServiceImpl
 * @Description HelloWorld服务接口具体实现类
 * @Author hwd
 * @Date 2020/9/10 9:56 PM
 * @Version 1.0
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public HelloWorld getHelloWorld() {
        return new HelloWorld("1", "Hello World Dubbo!", LocalDateTime.now());
    }
}
