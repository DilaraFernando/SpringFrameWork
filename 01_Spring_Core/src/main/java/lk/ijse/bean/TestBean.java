package lk.ijse.bean;

import org.springframework.stereotype.Component;

@Component("exampleBean")
public class TestBean {
    public TestBean(){
        System.out.println("Test Bean is created");
    }
    public void printMessage(){
        System.out.println("print message method close");
    }
}

