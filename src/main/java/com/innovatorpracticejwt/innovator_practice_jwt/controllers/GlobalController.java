package com.innovatorpracticejwt.innovator_practice_jwt.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovatorpracticejwt.innovator_practice_jwt.dto.PostDTO;
import com.innovatorpracticejwt.innovator_practice_jwt.dto.UpdatePostDTO;
import com.innovatorpracticejwt.innovator_practice_jwt.models.Posts;
import com.innovatorpracticejwt.innovator_practice_jwt.models.Users;
import com.innovatorpracticejwt.innovator_practice_jwt.repository.PostRepository;
import com.innovatorpracticejwt.innovator_practice_jwt.util.EntityHawk;
import com.innovatorpracticejwt.innovator_practice_jwt.util.PostMapper;

import io.jsonwebtoken.Claims;

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
@RequestMapping("/api")
public class GlobalController extends EntityHawk {

}
