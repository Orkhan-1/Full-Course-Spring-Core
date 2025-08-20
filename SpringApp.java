import com.orkhangasanov.autowired.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.orkhangasanov");

        NotificationService service = context.getBean(NotificationService.class);
        service.send("Hello, Spring!");
    }
}
