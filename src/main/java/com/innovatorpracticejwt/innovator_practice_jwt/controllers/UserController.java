package com.innovatorpracticejwt.innovator_practice_jwt.controllers;

import com.innovatorpracticejwt.innovator_practice_jwt.dto.LoginDto;
import com.innovatorpracticejwt.innovator_practice_jwt.dto.RegisterUserDTO;
import com.innovatorpracticejwt.innovator_practice_jwt.models.Users;
import com.innovatorpracticejwt.innovator_practice_jwt.repository.UserRepository;
import com.innovatorpracticejwt.innovator_practice_jwt.util.EntityHawk;
import com.innovatorpracticejwt.innovator_practice_jwt.util.JWTUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1460344
 */
@RestController
@RequestMapping("/")
public class UserController extends EntityHawk {

  @Autowired
  UserRepository userrep;

  @Autowired
  AuthenticationManager am;
  
  private JWTUtils Jwtutil;

  @PostMapping("/register")
  public void register(@RequestBody RegisterUserDTO reg){
    Users u = new Users();
    u.setUserName(reg.getName());
    u.setEmail(reg.getEmail());
    u.setPassword(reg.getPassword());
    userrep.save(u);
  }

  @PostMapping("/login")
  public EntityHawk login(@RequestBody LoginDto login){
    EntityHawk eh = new EntityHawk();
    Users user = userrep.findByEmail(login.getEmail());
    String token = Jwtutil.CreateJWTToken(user);
    eh.genericSuccess(token);
    return eh;
  }


}
