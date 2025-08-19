import com.orkhangasanov.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        // Without using Spring
        //CustomerService service = new CustomerService();
        //service.registerCustomer("Orkhan");

        // Using Spring

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService service = (CustomerService) context.getBean("service");
        service.registerCustomer("Orkhan");

    }
}
