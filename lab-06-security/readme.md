# Spring Boot Security

## Part One
* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
  * Web
  * Actuator
  * Security
* Start the application and do an HTTP GET on `http://localhost:8080/actuator`, or open in a browser
* You should see in your log output something like the following:
```text
Using generated security password: cbb45866-5bea-4c7e-acf5-218661ff1aef
```
* In your HTTP client, add a Basic Authorization header with the password from your log output, and the username `user`
* Alternatively, if you opened `/actuator` in a browser you should have been prompted with a form login
* Create a new class that extends `WebSecurityConfigurerAdapter` and is annotated with `@Configuration`
* Override the `configure(HttpSecurity http)` method and enter the following:
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
     http
             .authorizeRequests()
             .requestMatchers(EndpointRequest.to("health", "info")).permitAll()
             .requestMatchers(EndpointRequest.to("actuator")).hasRole("VIEW_ACTUATOR")
             //.antMatchers("/actuator/health", "/actuator/info").permitAll()
             //.antMatchers("/actuator/**").hasRole("VIEW_ACTUATOR")
             .anyRequest().authenticated()
             .and()
             .httpBasic();
 }
```
* Start the application and do an HTTP GET on `http://localhost:8080/health`, `http://localhost:8080/info`, and `http://localhost:8080/actuator`
* Do an HTTP GET on `http://localhost:8080/actuator`, adding the Basic Authorization header as stated earlier
* Add the property `spring.security.user.roles=VIEW_ACTUATOR` and restart

## Part Two
* To the `@Configuration` class, add the following:
  * `@EnableGlobalMethodSecurity(prePostEnabled = true)` at the class-level
```java
@Bean
public UserDetailsService userDetailsService() {
    User.UserBuilder users = User.withDefaultPasswordEncoder();
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(users.username("foo").password("foopass").roles("FOO").build());
    manager.createUser(users.username("bar").password("barpass").roles("BAR", "ADMIN").build());
    return manager;
}
```
* In your controller, annotate your 2 existing methods with one each:
  * `@PreAuthorize("isAuthenticated()")`
  * `@PreAuthorize("hasRole('FOO')")`
* Try to hit each of your endpoints with each user defined in the in-memory UserDetailsService
* Need to log the user ID, or bind to the MDC context?
  * Add either of the following to your controller method as a input parameter:
    * `java.security.Principal`
      * `principal.getName()`
    * `org.springframework.security.core.Authentication`
      * `authentication.getName()`
  * Call the static method `SecurityContextHolder.getContext().getAuthentication()`

## Notes
* https://spring.io/projects/spring-security
* https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-security
* https://docs.spring.io/spring-security/site/docs/5.1.4.RELEASE/reference/htmlsingle
