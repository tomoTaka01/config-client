package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Refresh
public class ConfigController {

    @Value("${app-config.config-key}")
    private String configVal ;

    @RequestMapping("/")
    @ResponseBody
    public String getConfig(){

        return configVal;
    }
}
