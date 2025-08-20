import com.orkhangasanov.configdemo.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.orkhangasanov.configdemo");
        AppConfig config = context.getBean(AppConfig.class);
        System.out.println(config.getName() + " v " + config.getVersion());
    }
}
