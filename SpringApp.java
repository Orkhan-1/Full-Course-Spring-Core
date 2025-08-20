import com.orkhangasanov.configdemo.AppConfigBean;
import com.orkhangasanov.configdemo.AppConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfigFile.class);
        AppConfigBean config = context.getBean(AppConfigBean.class);
        System.out.println(config.getName() + " v " + config.getVersion());
    }
}
