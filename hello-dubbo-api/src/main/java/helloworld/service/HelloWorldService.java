package helloworld.service;

import helloworld.domain.HelloWorld;

/**
 * @ClassName HelloWorldService
 * @Description HelloWorld服务方法接口
 * @Author hwd
 * @Date 2020/9/10 9:48 PM
 * @Version 1.0
 */
public interface HelloWorldService {
    HelloWorld batchInsertTest();

    HelloWorld selectTest();

    HelloWorld selectUserById(String id);

    HelloWorld updateTest();

    HelloWorld updateUserById(String id);

    HelloWorld deleteTest();

    HelloWorld deleteUserById(String id);
}
