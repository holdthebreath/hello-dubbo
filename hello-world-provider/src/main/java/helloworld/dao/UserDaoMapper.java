package helloworld.dao;

import helloworld.domain.User;
import org.apache.ibatis.annotations.*;

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

    /**
     * 批量插入mybatis selectKey只生成一次uuid,直接插入uuid mycat插入的是druid的对象名
     */
    @Insert({
            "<script>",
            "insert into user(id, user_name) values",
            "<foreach collection = 'list' item = 'item' index = 'index' separator = ','>",
            "(#{item.id}, #{item.userName})",
            "</foreach>",
            "</script>"
    })
    int insertUserList(List<User> userList);

    @Insert("insert into user(id, user_name) values (#{id}, #{userName})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select MD5(replace(uuid(), '-', ''))")
    int insertUser(User user);

    @Select("select * from user where user_name = #{name}")
    User selectUserByName(String name);

    @Select("select * from user where id = #{id}")
    User selectUserById(String id);

    @Update("update user set user_name = #{userName} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(String id);
}
