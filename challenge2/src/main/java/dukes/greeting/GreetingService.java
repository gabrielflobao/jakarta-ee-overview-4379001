package dukes.greeting;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

// The GreetingService should be a Stateless session bean
// Hint: Check out the @Stateless annotation
@Stateless
public class GreetingService {

    @Inject
    GreetingRepository repository;

    GreetingRecord findAll() {
        Greeting request = repository.findAll();
        GreetingRecord record = new GreetingRecord(request.getMessage(), LocalDate.now());
       return record;
    }

    public void save(GreetingRecord record) {
        repository.saveGreeting(record);
    }

    /**
     * Helpful documentation:
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/ejb/stateless
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/inject/package-summary.html
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
     */

    // inject the GreetingRepository

    // Create a method that calls the GreetingRepository to find all greetings, chooses the first one,
    // and maps it to a DTO in the form of a Record
    // If no greetings are returned from the repository, return a hard coded one with the text "Hello, World!"
    // and today's date.

    // Add a method that takes a GreetingRecord as parameter, maps it to a Greeting,
    // and calls the saveGreeting method on the GreetingRepository
}
