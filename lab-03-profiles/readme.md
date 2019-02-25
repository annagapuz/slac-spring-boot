# Spring Boot Profiles

* Spring Boot allows code and properties to be segregated using [profiles](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-profiles) 
* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
* Add another `@Component` annotated with `@Profile("local")` and a log statement in the constructor
* Run the application
* Switch to the command line add "local" to the list of profiles
  * `mvn -Dspring.profiles.active=local spring-boot:run`
* Add `@Profile("!devl")` to your previous `@Component`
* `mvn -Dspring.profiles.active=local,devl spring-boot:run`
* Add a new properties file named `application-local.yml`, copy over the first property you injected, and change the value
* `mvn -Dspring.profiles.active=local spring-boot:run`
