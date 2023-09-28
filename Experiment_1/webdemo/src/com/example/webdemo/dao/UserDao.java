package com.example. webdemo.dao;
import com.example.webdemo.model.User;
import java.util.Optional;

public interface UserDao {
    Optional<User> getUser(String username,String password) throws Exception;
}
