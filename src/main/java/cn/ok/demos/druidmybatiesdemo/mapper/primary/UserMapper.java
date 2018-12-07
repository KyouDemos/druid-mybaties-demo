package cn.ok.demos.druidmybatiesdemo.mapper.primary;

import cn.ok.demos.druidmybatiesdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * File Header
 *
 * @author kyou on 2018-12-06 22:39
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER")
    List<User> findAllUsers();
}
