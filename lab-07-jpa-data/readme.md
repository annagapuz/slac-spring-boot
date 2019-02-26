# Spring Boot Data Rest and JPA

## Part One
* Use [Spring Initializr](https://start.spring.io/) to generate a Spring Boot project with the following dependencies:
  * Configuration Processor
  * Web
  * Actuator
  * JPA
  * Rest Repositories
  * H2
* Add the following properties:
```properties
management.endpoint.health.show-details=always
management.endpoints.web.exposure.include=health,info,configprops,env,loggers,metrics,mappings
```
* Once you add in JPA you have to add a datasource
* Add two POJO classes, `AddressBook` and `Address` to represent a normalized database
  * With this example, the `List` of addresses in the `AddressBook` should be annotated with `@OneToMany(cascade = CascadeType.ALL) private List<Address> address;`
  * Make sure address has at least 2 other fields, e.g. city, state, street, postalCode
* Each POJO should implement `@Serializable` and be annotated with `@Entity`, and each primary key field should be annotated with `@Id`
* Create a Repository interface for each entity, in the following format:
```java
public interface YourPOJORepository extends CrudRepository<YourPOJO, Long>
// The first generic should be your entity/POJO
// The second generic should be the type of the primary key
```
* Start the application and do an HTTP GET on `http://localhost:8080`
* Need data? You can add data with code or with a SQL file
* Add a simple controller to load data into your embedded database, for example:
```java
@RestController
public class SampleController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/load")
    public void loadData() {
        AddressBook book = new AddressBook();
        book.setName("My H2 Address Book");

        Address address1 = new Address();
        address1.setStreet("123 Main Street");
        address1.setCity("Reston");
        address1.setState("VA");

        Address address2 = new Address();
        address2.setStreet("123 Foo Blvd");
        address2.setCity("Baltimore");
        address2.setState("MD");

        book.setAddress(Arrays.asList(address1, address2));

        addressBookRepository.save(book);
    }
}
```
* You can use [query creation by method name](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation) to expose the entity resource in a variety of ways
  * In `AddressRepository` add the following method:
    * `Address findFirstByCityStartsWith(String startingLetter);`
  * In `AddressBookRepository` add the following method:
    * `List<AddressBook> findByAddress_State(String state);`
* Start the application and go to:
  * `http://localhost:8080/addressBooks/search`
  * `http://localhost:8080/addresses/search`

## Notes
* https://spring.io/projects/spring-data-jpa
* https://spring.io/projects/spring-data-rest
* https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-initialize-a-database-using-jpa
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/