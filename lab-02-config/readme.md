# Spring Boot Properties and Externalized Configuration

## Part One
* Spring Boot maintains an [order of precedence](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config) for properties 
* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
* Inject a property into your `@Component` using `@Value` and a property key
* Use a `@PostConstruct` and a log statement to print out the property's value
* Add the property to `application.properties` and give it a value
* Switch to the command line
  * `mvn spring-boot:run`
  * `java -jar target/<your-app>.jar`
* Add a system property
  * `mvn -Dsome.property.key=property spring-boot:run`
  * `java -Dsome.property.key=property -jar target/<your-app>.jar`
* Add a command line argument
  * `mvn spring-boot:run -Dspring-boot.run.arguments=--some.property.key=argument`
  * `java -jar target/<your-app>.jar --some.property.key=argument`
* Add both a system property and a command line argument
  * `mvn -Dsome.property.key=property spring-boot:run -Dspring-boot.run.arguments=--some.property.key=argument`
  * `java -Dsome.property.key=property -jar target/<your-app>.jar --some.property.key=argument`

## Part Two
* Spring Boot allows you to [bind configuration properties to a strongly-typed bean](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-typesafe-configuration-properties), which is then available in the application context
* Rename `application.properties` to `application.yml` and refactor any existing properties
* Add a nested set of properties that start with the same prefix and includes a list
* Add a class annotated with `@ConfigurationProperties("your-prefix")` to bind to your properties, and `@Component` to construct the bean
* Autowire the new configuration bean into your previous `@Component` and log some of the property values

## Notes
* You can use [YAML format](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml) instead of key-value properties
* The `spring-boot-configuration-processor` dependency creates metadata about any configuration defined within your code. This makes working within an IDE easier with regard to your custom configuration.
