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
            Student s1 = new Student(4, "mere", "mere@gmail.com",60);
//            Serializable id = (Serializable) session.save(s1);
//            System.out.println(id);
            session.persist(s1);
            //save has been deprecated in hibernate 6 we can use persist();

            transaction.commit();
        }
        finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
