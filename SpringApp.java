import com.orkhangasanov.autowired.NotificationService;
import com.orkhangasanov.autowired.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.orkhangasanov");

        UserService service = context.getBean(UserService.class);
        service.register("Orkhan Gasanov");
    }
}
