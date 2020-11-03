package org.example.stream.controller;

import org.example.stream.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lch on 2020/11/2
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider provider;

    @GetMapping(value = "/send")
    public  String send(){
        return  provider.send();
    }
}