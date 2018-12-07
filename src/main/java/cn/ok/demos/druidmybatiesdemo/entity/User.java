package cn.ok.demos.druidmybatiesdemo.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author kyou on 2018-12-06 22:32
 */
@Data
public class User {
    private int id;
    private String userName;
    private int age;
    private long phone;
    private Date birthDay;

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd").create();
        return gson.toJson(this);
    }
}
