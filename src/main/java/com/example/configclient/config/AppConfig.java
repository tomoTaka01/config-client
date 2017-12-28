package com.example.configclient.config;

//@Configuration
//@ConfigurationProperties("app-config")
public class AppConfig {
    private String configKey1;
    private String configKey2;
    private String configKey3;

    public String getConfigKey1() {
        return configKey1;
    }

    public void setConfigKey1(String configKey1) {
        this.configKey1 = configKey1;
    }

    public String getConfigKey2() {
        return configKey2;
    }

    public void setConfigKey2(String configKey2) {
        this.configKey2 = configKey2;
    }

    public String getConfigKey3() {
        return configKey3;
    }

    public void setConfigKey3(String configKey3) {
        this.configKey3 = configKey3;
    }
}
