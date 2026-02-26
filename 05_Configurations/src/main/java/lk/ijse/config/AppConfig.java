package lk.ijse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
@Import({AppConfigOne.class,AppConfigTwo.class})
@ImportResource("classpath:hibernate.cfg.xml")
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig Constructor");
    }
}
