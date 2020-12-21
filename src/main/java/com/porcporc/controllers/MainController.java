package com.porcporc.controllers;

import com.porcporc.repository.CategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CategoriesRepository categoriesRepository;

    public MainController(){
        logger.info(getClass().getSimpleName() + " created");
    }

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("categories", categoriesRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/in-magazine")
    public ModelAndView getMag(){
        ModelAndView modelAndView = new ModelAndView("in-mag");
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(){
        ModelAndView modelAndView = new ModelAndView("contact");
        return modelAndView;
    }

    @GetMapping("/my-account")
    public ModelAndView getMyAccount(){
        ModelAndView modelAndView = new ModelAndView("my-account");
        return modelAndView;
    }

    @GetMapping("/client-nou")
    public ModelAndView getNewClient(){
        ModelAndView modelAndView = new ModelAndView("my-account");
        return modelAndView;
    }
}
