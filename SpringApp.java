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
