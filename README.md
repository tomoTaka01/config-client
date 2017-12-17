## Spring Boot Sample
  * As of Spring Boot Version 2.0.0.M7(2017-12-17)
  * Cloud Config Client Sample
  * config files location is ${HOME}/config-sample(see the repository config-sample)

  * to see the config value
```
http://localhost:8080/show/config
```

  * set profile
```
--spring.profiles.active=local
--spring.profiles.active=prod
```

  * config file should be in the git directory

```
config-sample
├── app-api-local.yml
├── app-api-prod.yml
├── app-api.yml
├── app-config-local.yml
├── app-config-prod.yml
└── app-config.yml
```
