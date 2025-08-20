import com.orkhangasanov.autowired.UserService;
import com.orkhangasanov.configdemo.AppConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfigFile.class);
        UserService config = context.getBean(UserService.class);
        config.register("Orkhan Gasanov");
    }
}
