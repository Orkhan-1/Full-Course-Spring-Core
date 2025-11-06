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

/*
 ===========================================================
                    JSR-250 Annotations
 ===========================================================

 Overview:
 ----------
 JSR-250 is a Java specification that defines a standard set of
 annotations for dependency injection, lifecycle callbacks, and
 security role management. It was originally part of Java EE and
 is now included in Jakarta EE.

 About Jakarta:
 ---------------
 Jakarta EE is the successor to Java EE, maintained by the Eclipse Foundation.
 All previous "javax" packages have been renamed to "jakarta".
 Example: javax.annotation.PostConstruct → jakarta.annotation.PostConstruct

 Spring Framework (since version 2.5) supports JSR-250 annotations and
 integrates them into the Spring container lifecycle.

 -----------------------------------------------------------
 Common JSR-250 Annotations and Their Purpose
 -----------------------------------------------------------

 1. @Resource
 - Injects a dependency by name.
 - Works similarly to @Autowired + @Qualifier("beanName").
 - Preferred when you want standard (non-Spring-specific) injection.
 - Example:
 @Resource(name = "myService")
 private MyService service;

 2. @PostConstruct
 - Marks a method to run after the bean is fully initialized.
 - Called once, immediately after dependency injection is complete.
 - Commonly used for initialization logic.
 - Example:
 @PostConstruct
 public void init() { ... }

 3. @PreDestroy
 - Marks a method to run just before the bean is destroyed.
 - Called when the ApplicationContext is closed or bean is removed.
 - Commonly used for cleanup logic or releasing resources.
 - Example:
 @PreDestroy
 public void cleanup() { ... }

 4. @RolesAllowed
 - Specifies security roles permitted to access a method or class.
 - Used in security-managed environments (e.g., Jakarta EE, Spring Security).
 - Example:
 @RolesAllowed({"ADMIN", "USER"})
 public void performAction() { ... }

 5. @RunAs
 - Declares a security role to be used when executing a component’s methods.
 - Used mainly in Jakarta EE for role-based execution.
 - Example:
 @RunAs("SYSTEM")

 6. @DeclareRoles
 - Declares a list of roles that the application will use.
 - Typically used along with @RolesAllowed and @RunAs.
 - Example:
 @DeclareRoles({"ADMIN", "USER", "GUEST"})

 -----------------------------------------------------------
 How Spring Recognizes @PostConstruct and @PreDestroy
 -----------------------------------------------------------

 1. Spring creates the bean instance (constructor is called).
 2. Dependencies are injected (via @Autowired, @Resource, etc.).
 3. Spring scans for methods annotated with @PostConstruct and invokes them.
 4. The bean becomes available for use in the ApplicationContext.
 5. When the context is closed, Spring calls any @PreDestroy methods before destroying the bean.

 -----------------------------------------------------------
 Stereotype Annotations (org.springframework.stereotype)
 -----------------------------------------------------------

 @Component  - Generic Spring-managed bean.
 @Service    - Service or business logic layer bean.
 @Repository - Data access or persistence layer bean.
 @Controller - Web controller (used in Spring MVC).

 All stereotype annotations make classes eligible for component scanning.
 They mainly differ by intent, indicating the logical role of the class.

 -----------------------------------------------------------
 Summary
 -----------------------------------------------------------

 - JSR-250 defines standard annotations for dependency injection,
 lifecycle, and role-based security.
 - Spring integrates @Resource, @PostConstruct, and @PreDestroy
 into its bean lifecycle automatically.
 - @Autowired and @Qualifier are Spring-specific injection mechanisms.
 - @Component, @Service, @Repository, and @Controller define the
 different types of beans managed by the Spring container.
 - @RolesAllowed, @RunAs, and @DeclareRoles are used for security metadata.
 */
