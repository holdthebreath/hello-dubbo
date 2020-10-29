package helloworld.domain;

/**
 * @ClassName User
 * @Description User实体类
 * @Author hwd
 * @Date 2020/10/29 9:17 PM
 * @Version 1.0
 */
public class User {
    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
