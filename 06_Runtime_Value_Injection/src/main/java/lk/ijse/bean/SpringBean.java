package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class SpringBean implements InitializingBean {
    @Value("Dilara")
    private String name = "SpringBean";

    public SpringBean() {
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterProperties setInitializationBean");
    }

}
