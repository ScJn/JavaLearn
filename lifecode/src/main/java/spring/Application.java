package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        try {
            new ClassPathXmlApplicationContext("spring.xml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
