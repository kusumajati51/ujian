package com.test.user.app.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.test.user.app.model.User;
import com.test.user.app.services.db_service.service.Email;
import com.test.user.app.services.db_service.service.UserRepoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserRepoService userRepoService;

    @PostMapping("/store")
    public @ResponseBody User store(@RequestBody User user) {
        userRepoService.addUser(user);
        try {
            new Email().sendEmail();
        } catch (MessagingException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping("/index")
    public @ResponseBody List<User> user(){
        return userRepoService.getAllUsers();
    }


}