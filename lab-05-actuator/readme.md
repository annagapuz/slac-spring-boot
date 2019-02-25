# Spring Boot Actuator

* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
  * Web
  * Actuator
* Start the application and do an HTTP GET on `http://localhost:8080/actuator`
* Do an HTTP GET on the `/health` and `/info` endpoints
* Add the property `management.endpoint.health.show-details` and set it to `always`
* Restart the application and do an HTTP GET on `http://localhost:8080/actuator/health`
* Add properties with the prefix of `info`, e.g.
```properties
info.app.name=My Sample Application
info.app.version=1.0
info.app.technical-details.language.kind=java
info.app.technical-details.language.version=1.8
```
* Restart the application and do an HTTP GET on `http://localhost:8080/actuator/info`
* [Expose the following endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints-exposing-endpoints)
  * configprops
  * env
  * loggers
  * metrics
  * mappings
* Do an HTTP POST on `http://localhost:8080/loggers/ROOT` with the following request body
```json
{
	"configuredLevel": "DEBUG"
}
```

## Notes
* https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready