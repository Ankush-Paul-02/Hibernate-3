package org.paul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

// Hibernate Query Language
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        /*
        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            Student student = new Student();
            student.setRollNumber(i);
            student.setName("Name " + i);
            student.setMarks(random.nextInt(40,100));
            session.save(student);
        }
        */

        /*Query query = session.createQuery("from Student where marks >= 90");
        List<Student> students = query.list();

        for (Student student : students) {
            System.out.println(student);
        }*/

        /*Query query = session.createQuery("select rollNumber, marks, name from Student where marks >= 95");
        List<Object[]> students = (List<Object[]>) query.list();

        for (Object[] student: students) {
            System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        }*/

        session.getTransaction().commit();
    }
}
