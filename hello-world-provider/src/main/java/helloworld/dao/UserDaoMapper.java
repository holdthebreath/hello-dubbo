package helloworld.dao;

import helloworld.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserDaoMapper
 * @Description user表数据库接口类
 * @Author hwd
 * @Date 2020/10/29 9:02 PM
 * @Version 1.0
 */
public interface UserDaoMapper {
    @Select("select * from user")
    List<User> getAllUser();
}
