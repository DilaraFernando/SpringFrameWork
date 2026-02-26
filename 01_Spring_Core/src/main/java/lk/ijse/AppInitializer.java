package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.SpringBean;
import lk.ijse.bean.TestBean;
import lk.ijse.config.AppConfig;
import lk.ijse.newBean.NewTestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        Bean ID
        SpringBean springBean = (SpringBean) context.getBean("springBean");
        System.out.println("Bean :" + springBean);

//        by class name
        TestBean testBean = (TestBean) context.getBean("exampleBean");
        System.out.println("Test Bean:" + testBean);

//        by bean ID
        TestBean testBean2 = (TestBean) context.getBean("exampleBean");
        System.out.println("Test Bean2 :" + testBean2);

//        by bean ID & class name
        TestBean testBean3 = (TestBean) context.getBean("exampleBean" , TestBean.class);
        System.out.println("Test Bean3 :" + testBean3);

        NewTestBean newTestBean = (NewTestBean) context.getBean("newTestBean",NewTestBean.class);
        System.out.println("New Test Bean :" +newTestBean);

        MyConnection myConnection = (MyConnection) context.getBean("myConnection",MyConnection.class);
        System.out.println("My Connection :" +myConnection);

        testBean.printMessage();
        testBean2.printMessage();
        testBean3.printMessage();

        context.registerShutdownHook();


    }
}