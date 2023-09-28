package com.example.webdemo.model;
import com.example.webdemo.util.DBUtil;

public class User {
        private String username;
        private String password;
        public User(String name,String pass){
            username=name;
            password=pass;
        }
        public String getUsername(){
            return username;
        }
        public void setUsername(String name){
            username=name;
        }
}
