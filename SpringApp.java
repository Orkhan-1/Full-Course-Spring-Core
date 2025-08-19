import com.orkhangasanov.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.orkhangasanov");

        CustomerService service = context.getBean(CustomerService.class);
        service.registerCustomer("Annotation Config Customer");
    }
}
