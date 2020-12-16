package com.porcporc.controllers;

import com.porcporc.entities.CategoriesEntity;
import com.porcporc.repository.CategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriesController {

    private static Logger logger = LoggerFactory.getLogger(CategoriesController.class);

    public CategoriesController(){
        logger.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/categories")
    public ModelAndView getCategories(){
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categoriesList", categoriesRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/categories/add")
    public ModelAndView addCategory() {
        ModelAndView modelAndView = new ModelAndView("categories-form");
        modelAndView.addObject("categories", new CategoriesEntity());
        return modelAndView;
    }
}
