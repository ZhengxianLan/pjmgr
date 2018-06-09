package com.citic.pjmgr.controller;

import com.citic.pjmgr.dao.UserRepository;
import com.citic.pjmgr.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lan on 6/10/18.
 */
//@RestController
@Controller
@RequestMapping("/projects")
public class ProjectCrotroller {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/new")
    public String greeting(/*@RequestParam(name = "name", required = false, defaultValue = "World") String name,*/ Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "new_project";
    }


    @GetMapping("/yo/{id}")
    @ResponseBody
    public String hello(@PathVariable(name = "id")int id) {
        return "hello"+id;
    }

}
