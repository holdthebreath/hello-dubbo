package hellodubbo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName HelloWorld
 * @Description 测试实体类
 * @Author hwd
 * @Date 2020/9/10 9:40 PM
 * @Version 1.0
 */
public class HelloWorld implements Serializable {
    private String id;
    private String message;
    private LocalDateTime getTime;

    public HelloWorld(){}

    public HelloWorld(String id, String message, LocalDateTime getTime){
        this.id = id;
        this.message = message;
        this.getTime = getTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getGetTime() {
        return getTime;
    }

    public void setGetTime(LocalDateTime getTime) {
        this.getTime = getTime;
    }
}
