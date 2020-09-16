package helloworld.web.controller;

import helloworld.domain.HelloWorld;
import helloworld.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Description HelloWorld控制器
 * @Author hwd
 * @Date 2020/9/10 9:44 PM
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @Reference
    private HelloWorldService helloWorldService;

    @GetMapping("/get")
    public HelloWorld getHelloWorld(){
        return helloWorldService.getHelloWorld();
    }
}
