package com.porcporc.controllers;

import com.porcporc.entities.ProductOrderEntity;
import com.porcporc.entities.ProductsEntity;
import com.porcporc.repository.ProductOrderRepository;
import com.porcporc.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    public ProductOrderController(){
        logger.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private ProductOrderRepository productOrderRepository;
    @Autowired
    private ProductRepository productRepository;




    @GetMapping("/orders")
    public ModelAndView checkOrders() {
        ModelAndView modelAndView = new ModelAndView("productOrder");
        modelAndView.addObject("orderList", productOrderRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/orders/{id}")
    public ModelAndView getOrder(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("productOrder");
        modelAndView.addObject("orderList", productOrderRepository.findById(id).get());
        return modelAndView;

    }

@GetMapping("/add-orders/{productId}")
public ModelAndView addOrder (@PathVariable Integer productId) {
    double x = productRepository.findById(productId).get().getPrice();
    ModelAndView modelAndView = new ModelAndView("redirect:/orders");
    ProductOrderEntity productOrderEntity = new ProductOrderEntity();
    productOrderEntity.setProductsId(productId);
    productOrderEntity.setQuantity(1);
    productOrderEntity.setPrice(x);
    modelAndView.addObject("productOrder", productOrderEntity);
    productOrderRepository.save(productOrderEntity);
    return modelAndView;
}



}
