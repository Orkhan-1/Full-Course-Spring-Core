import com.orkhangasanov.beanlifecycle.DemoBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("com.orkhangasanov");
        DemoBean bean = context.getBean(DemoBean.class);
        context.close();
    }
}
