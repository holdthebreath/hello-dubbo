package helloworld.service.impl;

import helloworld.dao.UserDaoMapper;
import helloworld.domain.HelloWorld;
import helloworld.domain.User;
import helloworld.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public HelloWorld batchInsertTest() {
        long startTime = System.currentTimeMillis();
        List<User> insertUserLit = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            User index = new User();
            index.setUserName(randomName(3, 20));
            index.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            insertUserLit.add(index);
        }
        userDaoMapper.insertUserList(insertUserLit);
        List<User> allUser = userDaoMapper.getAllUser();
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "插入100000用户,数据库现在共有 " + allUser.size() + "用户,共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }

    private String randomName(int min, int max) {
        String name;
        char[] nameChar;
        int nameLength = (int) (Math.random() * (max - min + 1)) + min;
        nameChar = new char[nameLength];
        nameChar[0] = (char) (Math.random() * 26 + 65);
        for (int i = 1; i < nameLength; i++) {
            nameChar[i] = (char) (Math.random() * 26 + 97);
        }
        name = new String(nameChar);
        return name;
    }

    @Override
    public HelloWorld selectTest(){
        long startTime = System.currentTimeMillis();
        List<User> allUser = userDaoMapper.getAllUser();
        String selectUserName = allUser.get((int)Math.round(Math.random() * allUser.size())).getUserName();
        User user = userDaoMapper.selectUserByName(selectUserName);
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "查询用户名称为" + user.getUserName() + ",共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }

    @Override
    public HelloWorld selectUserById(String id){
        long startTime = System.currentTimeMillis();
        User user = userDaoMapper.selectUserById(id);
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "查询用户名称为" + user.getUserName() + ",共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }

    @Override
    public HelloWorld updateTest(){
        long startTime = System.currentTimeMillis();
        List<User> allUser = userDaoMapper.getAllUser();
        User updateUser = allUser.get((int)Math.round(Math.random() * allUser.size()));
        return updateUserData(startTime, updateUser);
    }

    @Override
    public HelloWorld updateUserById(String id){
        long startTime = System.currentTimeMillis();
        User updateUser = userDaoMapper.selectUserById(id);
        return updateUserData(startTime, updateUser);
    }

    private HelloWorld updateUserData(long startTime, User updateUser) {
        String oldUserName = updateUser.getUserName();
        updateUser.setUserName(randomName(3, 20));
        userDaoMapper.updateUser(updateUser);
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "更新用户id为" + updateUser.getId() + "旧名称为" + oldUserName + ",新名称为" + updateUser.getUserName() + ",共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }

    @Override
    public HelloWorld deleteTest(){
        long startTime = System.currentTimeMillis();
        List<User> allUser = userDaoMapper.getAllUser();
        String deleteUserId = allUser.get((int)Math.round(Math.random() * allUser.size())).getId();
        userDaoMapper.deleteUser(deleteUserId);
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "删除用户id为" + deleteUserId + ",共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }

    @Override
    public HelloWorld deleteUserById(String id){
        long startTime = System.currentTimeMillis();
        userDaoMapper.deleteUser(id);
        long endTime = System.currentTimeMillis();
        return new HelloWorld("1", "删除用户id为" + id + ",共耗时" + (endTime - startTime) + "毫秒", LocalDateTime.now());
    }
}
