package helloworld.service.impl;

import helloworld.domain.HelloWorld;
import helloworld.domain.User;
import helloworld.service.HelloWorldService;
import helloworld.dao.UserDaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName HelloWorldServiceImpl
 * @Description HelloWorld服务接口具体实现类
 * @Author hwd
 * @Date 2020/9/10 9:56 PM
 * @Version 1.0
 */
@Slf4j
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private UserDaoMapper userDaoMapper;
    @Override
    public HelloWorld getHelloWorld() {
        List<User> allUser = userDaoMapper.getAllUser();
        return new HelloWorld(allUser.get(0).getId(), allUser.get(0).getUserName(), LocalDateTime.now());
    }
}
