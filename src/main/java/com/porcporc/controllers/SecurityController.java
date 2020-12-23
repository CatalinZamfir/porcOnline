package com.porcporc.controllers;

import com.porcporc.entities.AuthorityEntity;
import com.porcporc.entities.UserEntity;
import com.porcporc.repository.AuthorityRepository;
import com.porcporc.repository.CategoriesRepository;
import com.porcporc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    public SecurityController() {
        logger.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CategoriesRepository categoriesRepository;


    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        modelAndView.addObject("categoryList", categoriesRepository.findAll());
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
    public ModelAndView registerUserRequest( @ModelAttribute("user") UserEntity userEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
//        if(bindingResult.hasErrors()){
//            modelAndView.setViewName("register");
//            modelAndView.addObject("user", userEntity);
//            modelAndView.addObject("editMode",  false);
//            return modelAndView;
//        }
//        Optional<UserEntity> optionalUserEntity = userRepository.findById(userEntity.getUserId());
//        if (optionalUserEntity.isPresent()) {
//            UserEntity editedUserEntity = optionalUserEntity.get();
//            editedUserEntity.setPassword(userEntity.getPassword());
////            editedUserEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//            userEntity = editedUserEntity;
//        } else {
        userEntity.setEnabled(true);
//            userEntity.setPassword(userEntity.getPassword());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        }
        userEntity = userRepository.save(userEntity);
            AuthorityEntity authorityEntity = new AuthorityEntity();
            authorityEntity.setUser(userEntity);
            authorityEntity.setUsername(userEntity.getUsername());
            authorityEntity.setAuthority("USER");
            authorityRepository.save(authorityEntity);
        return modelAndView;
    }

    @GetMapping("/login-error")
    public ModelAndView loginError(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("login-form");
        String errorMessage = null;
        if (session != null) {
            Object object = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (object instanceof AuthenticationException) {
                errorMessage = "Wrong username or password";
            }
        }
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

}
