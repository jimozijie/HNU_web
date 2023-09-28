package com.example.webdemo.dao;

import com. example. webdemo.model.User;
import com.example.webdemo.util.DBUtil;

import java.sql.ResultSet;

import java.util.Optional;

public class UserDaoImpl implements UserDao{
    @Override
    public Optional<User> getUser(String username,String password) throws Exception{
        ResultSet rs=DBUtil.executeQuery("select* from users where username=? and password=?",username , password);
        Optional<User> result=Optional.empty();
        if(rs.next()) {
            result = Optional.of(new User(rs.getString("username"), rs.getString("password")));
        }
        DBUtil.closeAll();
        return result;
        }
    }
