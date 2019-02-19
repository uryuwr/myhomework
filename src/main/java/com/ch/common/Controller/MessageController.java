package com.ch.common.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Chen on 2019-02-16-16:19
 */
@Controller
@RequestMapping("/v0.1/message")
public class MessageController {
    @GetMapping("/audit")
    public String audit() {
        return "Audit";
    }
}
