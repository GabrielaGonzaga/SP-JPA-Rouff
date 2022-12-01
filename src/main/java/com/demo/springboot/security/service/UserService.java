package com.demo.springboot.security.service;
import com.demo.springboot.security.model.User;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}