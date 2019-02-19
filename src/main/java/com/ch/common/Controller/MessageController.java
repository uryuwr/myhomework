package com.ch.common.Controller;

import com.ch.common.config.MyWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Chen on 2019-02-16-16:19
 */
@RestController
@RequestMapping("/v0.1/message")
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @GetMapping("/send/{sid}")
    public String audit(@PathVariable String sid,@RequestParam String message) {
        try {
            MyWebSocket.sendInfo(message,sid);
        } catch (IOException e) {
            log.error("",e.getMessage());
        }
        return sid;
    }
}
