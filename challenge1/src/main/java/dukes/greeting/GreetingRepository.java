package dukes.greeting;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

// Give the repository an appropriate CDI scope. Hint: You can also use the pseudo-scope @Dependent
@Dependent
public class GreetingRepository {


    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public List<Greeting> getAllGreetings() {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Greeting.class));
        return em.createQuery(cq).getResultList();
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
}
