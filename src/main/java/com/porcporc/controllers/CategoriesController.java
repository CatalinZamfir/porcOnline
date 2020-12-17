package com.porcporc.controllers;

import com.porcporc.entities.CategoriesEntity;
import com.porcporc.entities.ProductsEntity;
import com.porcporc.repository.CategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView addCategories() {
        ModelAndView modelAndView = new ModelAndView("categories-formular");
        modelAndView.addObject("categories", new CategoriesEntity());
        return modelAndView;
    }

    @GetMapping("categories/edit/{id}")
    public ModelAndView editCategories(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("categories-formular");
        modelAndView.addObject("categories", categoriesRepository.findById(id).get());
        return modelAndView;
    }


    @GetMapping("/categories/delete/{id}")
    public ModelAndView deleteCategories(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("categories-formular");
        categoriesRepository.deleteById(id);
        return modelAndView;
    }




    @PostMapping("categories/save")
    public ModelAndView saveCategories(@ModelAttribute ProductsEntity product){
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        modelAndView.setViewName("categories-formular");
        modelAndView.addObject("categories", product);
        return modelAndView;
    }

}
