## Spring Boot Sample
  * As of Spring Boot Version 2.0.0.M7(2017-12-17)
  * Cloud Config Client Sample
  * to see the server https://github.com/tomoTaka01/config-server

  * for config setting file and server uri
    * bootstrap.yml
```yml
spring:
  application:
    name: app-config,app-api
  cloud:
    config:
      uri: http://localhost:8888
```

  * for app-config-{local,prod}.yml

```Java
@Configuration
@ConfigurationProperties("app-config")
public class AppConfig {
    private String configKey1;
    private String configKey2;
    private String configKey3;

    // setter and getter
}

```

  * for app-api-{local,prod}.yml

```Java
@Configuration
@ConfigurationProperties("app-api")
@Validated
public class AppApi {
    @Max(5)
    private int retryCount;
    private String apiName;
    // setter and getter
}
```

  * to see the config setting
    * ConfigController.java

```Java
@Controller
@RefreshScope
public class ConfigController {
    private final Environment environment;
    private final AppConfig appConfig;
    private final AppApi appApi;

    @Value("${app-config.config-key1}")
        private String configVal1;

    @Value("${app-config.config-key2}")
        private String configVal2;

    @Value("${app-config.config-key3}")
        private String configVal3;

    @Value("${app-api.retry-count}")
        private int retryCount;

    @Value("${app-api.api-name}")
        private String apiName;

    public ConfigController(Environment environment, AppConfig appConfig, AppApi appApi) {
        this.environment = environment;
        this.appConfig = appConfig;
        this.appApi = appApi;
    }

    @RequestMapping("/show/config")
        @ResponseBody
        public String getConfig() {
            String activeProfiles = String.format("active prodiles=[%s]<br>", Arrays.toString(environment.getActiveProfiles()));

            String appConfig = String.format("*** app-config:key1=[%s], key2=[%s], key3=[%s]<br>", configVal1, configVal2, configVal3);
            String appApi = String.format("*** app-api:retryCount=[%d], apiname=[%s]<br>", retryCount, apiName);

            String appConfigByClass = String.format("*** app-config from AppConfig.java:key1=[%s], key2=[%s], key3=[%s]<br>"
                    , this.appConfig.getConfigKey1(), this.appConfig.getConfigKey2(), this.appConfig.getConfigKey3());
            String appApiByClass = String.format("*** app-api from AppApi.java:retryCount=[%d], apiName=[%s]<br>"
                    , this.appApi.getRetryCount(), this.appApi.getApiName());

            return activeProfiles + appConfig + appApi + appConfigByClass + appApiByClass;
        }
}

```

  * to confirm yml setting for each environment from Config Server
    * for local environment, start application with --spring.profiles.active=local
    * visit the uri http://localhost:8080/show/config

```
active prodiles=[[local]]
*** app-config:key1=[val1-default], key2=[val2-local], key3=[val3-default]
*** app-api:retryCount=[1], apiname=[ローカル用ＡＰＩ名]
*** app-config from AppConfig.java:key1=[val1-default], key2=[val2-local], key3=[val3-default]
*** app-api from AppApi.java:retryCount=[1], apiName=[ローカル用ＡＰＩ名]
```

  * to confirm yml setting for each environment from Config Server
    * for prod environment, start application with --spring.profiles.active=prod
    * visit the uri http://localhost:8080/show/config

```
active prodiles=[[prod]]
*** app-config:key1=[val1-default], key2=[val2-default], key3=[val3-prod]
*** app-api:retryCount=[1], apiname=[本番用ＡＰＩ名]
*** app-config from AppConfig.java:key1=[val1-default], key2=[val2-default], key3=[val3-prod]
*** app-api from AppApi.java:retryCount=[1], apiName=[本番用ＡＰＩ名]
```

