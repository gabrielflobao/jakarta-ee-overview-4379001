package dukes.greeting;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// The GreetingServlet should be an HttpServlet
// Hint: Check the @WebServlet annotation, URL pattern for the servlet should be "/greeting"
// Hint: extend HttpServlet
@WebServlet(name = "GreetingServlet", urlPatterns = "/greeting")
public class GreetingServlet extends HttpServlet {
    @EJB
    GreetingService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        resp.getWriter().println(service.findAll().getMessage());
    }



    /**
     * Helpful documentation:
     *
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/servlet/annotation/webservlet
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/servlet/http/httpservlet
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/servlet/http/httpservletrequest
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/servlet/http/httpservletresponse
     */

    // Inject the GreetingService EJB
    // Hint: Check out the @EJB annotation

    // override the doGet method from HttpServlet
    // get the message from the greeting and display it
    // Hint: resp.getWriter().println("text");
}
