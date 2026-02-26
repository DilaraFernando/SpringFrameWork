package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Autowired
    @Qualifier("girlOne")
   Agreement agreement;

    public Boy(){
        System.out.println("Boy obj created.");
    }
    public void chatWithGirl() {
      agreement.chat();
    }
}
