package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements ApplicationContextAware, BeanFactoryAware,BeanNameAware, InitializingBean, DisposableBean {
    public SpringBean(){
        System.out.println("Spring bean is created");
    }
    public void setBeanFactory(BeanFactory beanFactory)throws BeansException{
        System.out.println("setBeanFactory is called");
    }
    public void setBeanName(String name){
        System.out.println("setBeanName is called");
    }
    public void destroy()throws Exception{
        System.out.println("destroy is called");
    }
    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException{
        System.out.println("setApplication is called");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterProperties is called");
    }
}
