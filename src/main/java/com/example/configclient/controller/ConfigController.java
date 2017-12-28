package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class ConfigController {
//    private final Environment environment;
//    private final AppConfig appConfig;
//    private final AppApi appApi;

////    @Value("${app-config.config-key1}")////
////    private String configVal1;////

//    @Value("${app-config.config-key2}")
//    private String configVal2;

//    @Value("${app-config.config-key3}")
//    private String configVal3;

//    @Value("${app-api.retry-count}")
//    private int retryCount;

//    @Value("${app-api.api-name}")
//    private String apiName;

    @Value("${foo}")
    private String vaultFoo;

    @Value("${baz}")
    private String vaultBaz;

//    public ConfigController(Environment environment, AppConfig appConfig, AppApi appApi) {
//        this.environment = environment;
//        this.appConfig = appConfig;
//        this.appApi = appApi;
//    }

    //    @RequestMapping("/show/config")
//    @ResponseBody
//    public String getConfig() {
//        String activeProfiles = String.format("active prodiles=[%s]<br>", Arrays.toString(environment.getActiveProfiles()));
//
//        String appConfig = String.format("*** app-config:key1=[%s], key2=[%s], key3=[%s]<br>", configVal1, configVal2, configVal3);
//        String appApi = String.format("*** app-api:retryCount=[%d], apiname=[%s]<br>", retryCount, apiName);
//
//        String appConfigByClass = String.format("*** app-config from AppConfig.java:key1=[%s], key2=[%s], key3=[%s]<br>"
//                , this.appConfig.getConfigKey1(), this.appConfig.getConfigKey2(), this.appConfig.getConfigKey3());
//        String appApiByClass = String.format("*** app-api from AppApi.java:retryCount=[%d], apiName=[%s]<br>"
//                , this.appApi.getRetryCount(), this.appApi.getApiName());
//
//        return activeProfiles + appConfig + appApi + appConfigByClass + appApiByClass;
//    }
    @RequestMapping("/show/vaultconfig")
    @ResponseBody
    public String getVaultConfig() {
        String config = String.format("vault:foo=[%s], baz=[%s]", vaultFoo, vaultBaz);
        return config;
    }
}
