import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.orkhangasanov.HelloWorld;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld hello = (HelloWorld) context.getBean("helloBean");

        hello.sayHello();
    }
}

/*

1) Tight Coupling
2) Hard to Test
3) No Centralized Configuration
Object’s creation is scattered throughout your codebase
4) You Manage the Lifecycle Manually
Creating it, initializing it, destroying it, cleaning up resources, etc.
5) Poor Scalability

*/
