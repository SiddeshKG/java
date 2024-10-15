package com.kgs.application;


import com.kgs.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
public class program {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            //Create session factory
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            //Create session
             session = sessionFactory.openSession();
             //create transaction
            Transaction transaction = session.beginTransaction();
            //CRUD operation
            Student s1 = new Student(3, "mori", "mori@gmail.com");
            Serializable id = (Serializable) session.save(s1);
            System.out.println(id);
            //save has been deprecated in hibernate 6 we can use persist();

            transaction.commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
