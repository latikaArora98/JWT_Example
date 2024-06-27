package com.innovatorpracticejwt.innovator_practice_jwt.repository;

import com.innovatorpracticejwt.innovator_practice_jwt.models.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1460344
 */
public interface UserRepository extends JpaRepository<Users,Integer> {

	Users findByEmail(String email);
   
}
