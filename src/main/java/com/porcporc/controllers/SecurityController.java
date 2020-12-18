package com.porcporc.controllers;

import com.porcporc.entities.UserEntity;
import com.porcporc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    public SecurityController() {
        logger.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        return modelAndView;

    }


    @GetMapping("/register")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new UserEntity());
        modelAndView.addObject("editMode", false);
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView saveProducts (@Valid @ModelAttribute("register") UserEntity userEntity, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("register");
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            modelAndView.addObject("user", userEntity);
            return modelAndView;
        }
        userRepository.save(userEntity);
        return modelAndView;
    }




}
