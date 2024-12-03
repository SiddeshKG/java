package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
 ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Allien obi = (Allien) context.getBean("allien");
        obi.code();
       // obi.setAge(21);
        System.out.println(obi.getAge());

//        Allien obi1 = (Allien) context.getBean("allien");
//        obi1.code();
//
//        System.out.println(obi1.age);

    }

}
