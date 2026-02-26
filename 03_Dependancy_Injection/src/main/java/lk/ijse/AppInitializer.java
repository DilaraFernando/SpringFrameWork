package lk.ijse;

import lk.ijse.bean.Boy;
import lk.ijse.config.AppConfig;
import lk.ijse.di.TestOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        TestOne testOne =context.getBean(TestOne.class);
        TestOne.chatWithTestTwo();

        context.registerShutdownHook();
    }
}