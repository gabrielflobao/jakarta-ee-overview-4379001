package dukes.greeting;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Optional;

// The GreetingService should be a Stateless session bean
// Hint: Check out the @Stateless annotation
@Stateless
public class GreetingService {
    @Inject
    GreetingRepository repository;


    Greeting findAll() {
        return repository.getAllGreetings().stream()
                .findFirst().orElse(new Greeting("Hello, world!"));
    }

    /**
     * Helpful documentation:
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/ejb/stateless
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/inject/package-summary.html
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
     */

    // inject the GreetingRepository

    // Create a method that calls the GreetingRepository to find all greetings and chooses the first one
    // If no greetings are returned from the repository, return a hard coded one with the text "Hello, World!"

}
