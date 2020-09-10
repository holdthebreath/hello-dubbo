package hellodubbo.web.controller;

import hellodubbo.domain.HelloWorld;
import hellodubbo.service.HelloWorldService;
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
