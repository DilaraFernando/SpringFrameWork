package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


    @Component
    @Primary
    public class GirlTwo implements Agreement, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean, ApplicationContextAware {

        public GirlTwo(){
            System.out.println("Girl obj created.");
        }
        public void chat(){
            System.out.println("Girl chat");
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryAware setBeanFactory");

        }

        @Override
        public void setBeanName(String name) {
            System.out.println("BeanNameAware setBeanName");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("DisposableBean is Destroy");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(" InitializationBean AfterProperties");

        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println("ApplicationContext setApplicationContext");
        }
    }


