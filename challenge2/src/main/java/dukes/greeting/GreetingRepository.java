package dukes.greeting;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.Optional;

// Give the repository an appropriate CDI scope. Hint: You can also use the pseudo-scope @Dependent
@Dependent
public class GreetingRepository {


    @PersistenceContext()
    private EntityManager em;

    public Greeting findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Greeting.class));
        Optional<Greeting> result = em.createQuery(cq).getResultList().stream().findFirst();
        return result.orElse(new Greeting("Hello World!"));
    }

    public void saveGreeting(GreetingRecord record) {
        Greeting greetingSave = new Greeting();
        greetingSave.setMessage(record.message());
        em.persist(greetingSave);
    }
    /**
     * Helpful documentation:
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/persistence/entitymanager
     */

    // define an EntityManager
    // Hint: Use the @PersistenceContext qualifier
    // Hint: Check the persistence.xml file for the unitName

    // Create a method that retrieves all greetings from the database. Return type should be List<Greeting>

    // Hint: Check out the Criteria Language for building queries
    // CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
    // cq.select(cq.from(Greeting.class));
    // return em.createQuery(cq).getResultList();

    // Create a method called saveGreeting that persists a greeting to the database
    // Hint: Use the persist(Object entity)-method on the EntityManager
}
