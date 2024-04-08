package dukes.greeting;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

// request scoped
// set the path to /greeting
@Path("/greeting")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @EJB
    GreetingService greetingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingRecord getGreeting() {
        return greetingService.findAll();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postGreeting(GreetingRecord greetingRecord) {
         greetingService.save(greetingRecord);
    }

    /**
     * Helpful documentation:
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/ws/rs/package-summary.html
     */

    // Inject the Greetings Service EJB

    // Add a method that responds to a HTTP GET and returns a greeting record
    // received from the Greeting Service

    // Add a method that responds to HTTP POST, consumes APPLICATION/JSON,
    // Maps it to a Greeting Record and saves it using the GreetingRecord

}
