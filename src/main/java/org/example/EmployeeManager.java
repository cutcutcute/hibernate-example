package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.util.List;


public class EmployeeManager {

    private SessionFactory sessionFactory;

    public EmployeeManager(){
        System.out.println(System.getProperty("user.dir"));

        File[] fiels = new File(System.getProperty("user.dir")).listFiles();
        for (File file : fiels){
            System.out.println(file);
        }
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

    }


    public List<User> getAllEmployes(){
        try(Session session = sessionFactory.openSession()){
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();

        }

    }


    public void addUser(User user){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();

        }
    }


    public User getUserById(Integer id){
        try (Session session = sessionFactory.openSession()){
            User user = session.get(User.class, id);
            return user;
        }
    }

    public User getUserByIdWithQuery(Integer id){
        try (Session session = sessionFactory.openSession()){
            String hql = "from User where id = " + id;
            Query<User> query = session.createQuery(hql, User.class);
            return query.uniqueResult();

        }

    }


    public boolean removeUser(User user){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(user);

            transaction.commit();
            return true;
        } catch(Exception ex) {
            return false;
        }

    }

}
