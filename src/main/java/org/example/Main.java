package org.example;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();


        // Add user

        //User user = new User();
        //user.setData("Vladimir", 28);
        //employeeManager.addUser(user);


        // get user by id
        /**

         Здесь можно использовать два способа
         1 - Через get
         2 - Через hql запрос

         По итогу и там и там запросы будут отправляться идентичные

         Hibernate: select u1_0.id,u1_0.age,u1_0.name from user u1_0 where u1_0.id=?
         Username - Олег
         Age - 44
         Hibernate: select u1_0.id,u1_0.age,u1_0.name from user u1_0 where u1_0.id=2
         Username - Ivan
         Age - 5
         */


        User userGet = employeeManager.getUserById(3);
        System.out.println(userGet.toString());

        User userFromQuery = employeeManager.getUserByIdWithQuery(2);
        System.out.println(userFromQuery.toString());

        //delete user
        //booleaTn isDelete = employeeManager.removeUser(userGet);
        //if (isDelete)
        //    System.out.println("user has been deleted");
    }
}