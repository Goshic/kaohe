package com.study.Mapper;
import com.study.pojo.User;

import java.util.List;

/**
 * @author 123
 */
public interface UserMapper {
    List<User> getUserList();
    Integer addUser(User user);
    Integer zhaoUser(User user);
}
