package com.study.Mapper;
import com.study.pojo.User;

import java.util.List;

/**
 * @author 123
 */
public interface UserMapper {
    List<User> getUserList();
    int addUser(User user);
}
