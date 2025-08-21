import com.orkhangasanov.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class SpringMVC {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        // Create context first
        Context context = tomcat.addContext("", null);

        // Create Spring context but DON'T refresh it yet
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebConfig.class);

        // Create DispatcherServlet with the Spring context
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // Add servlet to Tomcat
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/*", "dispatcher");

        // Start Tomcat first - this will create the ServletContext
        tomcat.start();

        // Now the ServletContext is available, we can refresh the Spring context
        // The DispatcherServlet will handle this automatically

        System.out.println("Server started on port 8080");
        System.out.println("Test with: curl -X POST \"http://localhost:8080/api/users/register?name=Orkhan\"");

        tomcat.getServer().await();
    }
}
