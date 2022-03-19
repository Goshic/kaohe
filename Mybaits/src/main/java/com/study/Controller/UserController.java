package com.study.Controller;

import com.study.Mapper.UserMapper;
import com.study.common.Result;
import com.study.pojo.User;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    SqlSession sqlSession= MybatisUtils.getSqlSession();
    UserMapper usermapper=sqlSession.getMapper(UserMapper.class);

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        List<User> userList=usermapper.getUserList();
        for (User res : userList) {
            if (res.getName().equals(user.getName()) && res.getPwd().equals(user.getPwd())){
                return Result.success();
            }
        }
        return Result.error("-1","用户名或密码错误");
    }
    @PostMapping("/register")
    public Result<?> addUser(@RequestBody User user){
        List<User> userList=usermapper.getUserList();
        for (User res : userList) {
            if (res.getName().equals(user.getName())){
                return Result.error("-1","用户名已存在");
            }
        }
        usermapper.addUser(user);
        sqlSession.commit();
        return Result.success();
    }
}
