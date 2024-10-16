package com.kgs.application;

import com.kgs.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Program_Read {

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

//                     //CRUD operation to get singe record
//                     Student s = session.get(Student.class, 1);
//                     System.out.println(s);
                     //save has been deprecated in hibernate 6 we can use persist();

                     //HQL query
                  String query ="From Student S where S.name like 'm%'";
                     Query query1 = session.createQuery(query);
                     List students = query1.list();
                        display(students);
                     transaction.commit();
                 }
                 finally {
                    if(session!= null){ session.close();}
                    if(sessionFactory!= null){ sessionFactory.close();}

                 }
    }
    public static void display(List students){

        for(Object student : students){
            System.out.println(student);


        }

    }
}
