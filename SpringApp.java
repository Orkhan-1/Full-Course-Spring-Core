import com.orkhangasanov.autowired.UserService;
import com.orkhangasanov.configdemo.AppConfigBean;
import com.orkhangasanov.configdemo.AppConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        // Set active profile (you can do this in multiple ways)
        // Option 1: System property
        System.setProperty("spring.profiles.active", "prod");

        // Option 2: Environment variable
        // export SPRING_PROFILES_ACTIVE=prod

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigFile.class);
        AppConfigBean config = context.getBean(AppConfigBean.class);
        config.displayConfig();
    }
}
