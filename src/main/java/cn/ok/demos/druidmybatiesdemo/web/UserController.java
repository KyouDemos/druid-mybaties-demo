package cn.ok.demos.druidmybatiesdemo.web;

import cn.ok.demos.druidmybatiesdemo.mapper.primary.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File Header
 *
 * @author kyou on 2018-12-06 22:38
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("GetAllUser")
    String getAllUser() {

        return userMapper.findAllUsers().toString();
    }
}
