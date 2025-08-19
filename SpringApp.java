import com.orkhangasanov.CustomerRepository;
import com.orkhangasanov.CustomerService;
import com.orkhangasanov.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        CustomerService service = context.getBean(CustomerService.class);
        service.registerCustomer("Java Config Customer");

    }
}
