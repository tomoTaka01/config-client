package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigController {

    @Value("${app-config.config-key}")
    private String configVal ;

    @Value("${app-api.retry-count}")
    private int retryCount;

    @RequestMapping("/")
    @ResponseBody
    public String getConfig(){

        String response = String.format("[%s], [%d]", configVal, retryCount);
        return response;
    }
}
