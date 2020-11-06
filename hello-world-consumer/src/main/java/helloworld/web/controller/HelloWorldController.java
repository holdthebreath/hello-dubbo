package helloworld.web.controller;

import helloworld.domain.HelloWorld;
import helloworld.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/batch-insert-test")
    public HelloWorld batchInsertTest(){
        return helloWorldService.batchInsertTest();
    }

    @GetMapping("/select-user-test")
    public HelloWorld selectUserTest(){
        return helloWorldService.selectTest();
    }

    @GetMapping("/update-user-test")
    public HelloWorld updateUserTest(){
        return helloWorldService.updateTest();
    }

    @GetMapping("/delete-user-test")
    public HelloWorld deleteUserTest(){
        return helloWorldService.deleteTest();
    }

    @GetMapping("/select-user-by-id/{id}")
    public HelloWorld selectUserById(@PathVariable String id){
        return helloWorldService.selectUserById(id);
    }

    @GetMapping("/update-user-by-id/{id}")
    public HelloWorld updateUserById(@PathVariable String id){
        return helloWorldService.updateUserById(id);
    }

    @GetMapping("/delete-user-by-id/{id}")
    public HelloWorld deleteUserById(@PathVariable String id){
        return helloWorldService.deleteUserById(id);
    }
}
