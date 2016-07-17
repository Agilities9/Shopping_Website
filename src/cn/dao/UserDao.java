package cn.dao;

import java.util.List;

import cn.bean.User;

public interface UserDao {

public boolean findUser(User user);
public List<User> findAllUser();
public boolean doUsers(String username,String password,String sex,String address,String question,String answer);
}
