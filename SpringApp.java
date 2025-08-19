import com.orkhangasanov.CustomerRepository;
import com.orkhangasanov.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerRepository r1 = (CustomerRepository) context.getBean("repoSingleton");
        CustomerRepository r2 = (CustomerRepository) context.getBean("repoSingleton");

        System.out.println(r1 == r2); // true (same instance)

        CustomerRepository r3 = (CustomerRepository) context.getBean("repoPrototype");
        CustomerRepository r4 = (CustomerRepository) context.getBean("repoPrototype");

        System.out.println(r3 == r4); // false (new instance)

    }
}
