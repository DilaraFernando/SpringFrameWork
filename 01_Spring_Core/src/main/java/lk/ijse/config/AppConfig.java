package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.bean","lk.ijse.newBean"})
public class AppConfig {
    public AppConfig(){
        System.out.println("AppConfig is created");
    }
    @Bean
    MyConnection myConnection(){
        return new MyConnection();
    }
}
