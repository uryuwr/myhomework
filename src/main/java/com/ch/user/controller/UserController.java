package com.ch.user.controller;

import com.ch.common.Listeners.TestEvent;
import com.ch.user.domain.Registry;
import com.ch.user.repository.RegistryRepository;
import com.ch.common.handle.UserHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chen on 2019
 */
@RestController
@RequestMapping("/v0.1/user")
public class UserController {
    @Autowired
    private RegistryRepository registryRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/user_info")
    public Registry test() {
        return UserHandle.getUser();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Registry registry, HttpServletRequest request) {
        Registry po = registryRepository.findByUserName(registry.getUserName());
       if (po != null && po.getPassword().equals(registry.getPassword())) {
            request.getSession().removeAttribute("user_info");
            request.getSession().setAttribute("user_info",po);
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user_info");
        try {
            response.sendRedirect("/view/login.html");
        } catch (IOException e) {
            logger.error("io error",e);
        }
    }

    @Autowired
    private ApplicationContext publisher;

    @PostMapping("/audit")
    public void hello() {
        TestEvent event = new TestEvent(this,"123456");
        publisher.publishEvent(event);
        System.out.println("发布成功");
    }
}
