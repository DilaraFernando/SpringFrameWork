package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {

    @Bean
    public SpringBean1 springBean1(){
        System.out.println();
        return new SpringBean1();


    }
    @Bean
    public SpringBean2 springBean2(){
        return new  SpringBean2();
    }
}
