# Spring Boot RESTful Service

## Part One
* At this stage it is recommended to start a new project
* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
  * Web
* Start the application and you will see an embedded tomcat server was started on port 8080
* You can also run on Jetty or Undertow
  * Exclude Tomcat and add in the Jetty or Undertow dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>

<!-- OR -->

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>

```
* Create a POJO with a 2 fields, an Integer and a String
* Create a new class annotated with `@RestController`
* Add a public method to the controller that returns the POJO and annotate it with `@RequestMapping("/hello")`
  * Return a newly instantiated POJO for now
* Start the application and use an HTTP client (IntelliJ, Postman) to hit `http://localhost:8080/hello`
  * Notice all HTTP methods (verbs) are mapped
* Restrict the endpoint to only work with GET requests
* To the method above, add a String parameter called "name", annotate it with `@RequestParam(value="name", defaultValue="World")`, and set that incoming value within your POJO before returning it
* Add another method to the controller that returns the POJO and annotate it with `@GetMapping(value = "/name/{name}")`
* To the new method, add a String parameter called "name", annotate it with `@PathVariable`, and set that incoming value within your POJO before returning it

## Part Two
* Errors can be managed at the controller level or globally, using `@ExceptionHandler` and `@ControllerAdvice`
* Throw an IllegalArgumentException for your `@GetMapping` if the value provided is less than 2 characters
* Fill out the following method:
```java
@ExceptionHandler
public ResponseEntity<yourPOJO> handle(IllegalArgumentException ex) {
    // Instantiate your POJO
    // set the String value of your POJO to the exception message
    // set the Integer value of your POJO to the int value of HttpStatus.BAD_REQUEST
    return new ResponseEntity<>(yourPOJO, HttpStatus.BAD_REQUEST);
}
```
* Start the application and try to trigger the exception
* Create a new class that extends `ResponseEntityExceptionHandler` and is annotated with `@ControllerAdvice`
* Cut the `@ExceptionHandler` method out from the controller and move it to the new class
* Start the application again and try to trigger the exception


## Notes
* https://spring.io/guides/gs/rest-service/
* https://docs.spring.io/spring/docs/5.1.5.RELEASE/spring-framework-reference/web.html#spring-web