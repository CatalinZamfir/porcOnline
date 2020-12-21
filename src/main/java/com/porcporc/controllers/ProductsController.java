package com.porcporc.controllers;

import com.porcporc.entities.CategoriesEntity;
import com.porcporc.entities.ProductsEntity;
import com.porcporc.repository.CategoriesRepository;
import com.porcporc.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductsController {

    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;


    public ProductsController(){
        logger.info(getClass().getSimpleName() + " created");
    }


    @GetMapping("/view-products/{id}")
    public ModelAndView getProducts(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("categories", categoriesRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/products/add/{categoriesId}")
    public ModelAndView addProducts (@PathVariable Integer categoriesId) {
        ModelAndView modelAndView = new ModelAndView("products-formular");
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setProductsId(categoriesId);
        modelAndView.addObject("products", productsEntity);
        return modelAndView;
    }

    @PostMapping("/products/save")
    public ModelAndView saveProducts (@Valid @ModelAttribute("products") ProductsEntity product,BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/view-products/" + product.getCategoriesId());
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("products-formular");
            modelAndView.addObject("product", product);
            return modelAndView;
        }
        productRepository.save(product);
        return modelAndView;
    }

    @GetMapping("/products/edit/{id}")
    public ModelAndView editProducts (@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("products-formular");
        ProductsEntity productsEntity = productRepository.findById(id).get();
        modelAndView.addObject("products", productsEntity);
        return modelAndView;
    }

    @GetMapping("/products/delete/{id}")
    public ModelAndView deleteProducts (@PathVariable Integer id){
        ProductsEntity productsEntity = productRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("redirect:/view-products/"+ productsEntity.getProductsId());
        productRepository.delete(productsEntity);
        return modelAndView;
    }





}
