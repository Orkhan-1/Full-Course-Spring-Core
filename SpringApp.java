import com.orkhangasanov.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.orkhangasanov.HelloWorld;

public class SpringApp {
    public static void main(String[] args) {

        // Without using Spring
        CustomerService service = new CustomerService();
        service.registerCustomer("Orkhan");
    }
}
