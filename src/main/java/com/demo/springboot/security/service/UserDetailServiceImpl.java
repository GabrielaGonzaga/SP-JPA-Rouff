package com.demo.springboot.security.service;

import com.demo.springboot.security.model.User;
import com.demo.springboot.security.repository.UserRepository;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserDetailServiceImpl implements UserService, UserDetailsService {
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  UserRepository userRepository;

  @Override
  public void saveUser(User user) {
    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    //        user.setRole(Role.USER);
    userRepository.save(user);
  }

  public void updateUser(
    Long id,
    MultipartFile pic,
    String firstName,
    String lastName,
    String email,
    String password,
    String CEP,
    String mobile
  ) {
    User obj = new User();
    String fileName = StringUtils.cleanPath(pic.getOriginalFilename());
    if (fileName.contains("..")) {
      System.out.println("not a a valid file");
    }
    try {
      obj.setPic(Base64.getEncoder().encodeToString(pic.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    User user = userRepository.findById(id).get();

    user.setPic(fileName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    String encodedPassword = bCryptPasswordEncoder.encode(password);
    user.setPassword(encodedPassword);
    user.setCEP(CEP);
    user.setMobile(mobile);
    userRepository.save(user);
  }

  @Override
  public List<Object> isUserPresent(User user) {
    boolean userExists = false;
    String message = null;
    Optional<User> existingUserEmail = userRepository.findByEmail(
      user.getEmail()
    );
    if (existingUserEmail.isPresent()) {
      userExists = true;
      message = "Email Already Present!";
    }
    Optional<User> existingUserMobile = userRepository.findByMobile(
      user.getMobile()
    );
    if (existingUserMobile.isPresent()) {
      userExists = true;
      message = "Mobile Number Already Present!";
    }
    if (existingUserEmail.isPresent() && existingUserMobile.isPresent()) {
      message = "Email and Mobile Number Both Already Present!";
    }
    System.out.println(
      "existingUserEmail.isPresent() - " +
      existingUserEmail.isPresent() +
      "existingUserMobile.isPresent() - " +
      existingUserMobile.isPresent()
    );
    return Arrays.asList(userExists, message);
  }

  @Override
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    return userRepository
      .findByEmail(email)
      .orElseThrow(
        () ->
          new UsernameNotFoundException(String.format("USER_NOT_FOUND", email))
      );
  }
}
