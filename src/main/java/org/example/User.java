package org.example;


import jakarta.persistence.*;

@Entity
@Table(name="user", schema = "test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 100, nullable = false, unique = false)
    public String name;
    public int age;



    public void setData(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Username - ")
                .append(this.name)
                .append("\nAge - ")
                .append(this.age);

        return sb.toString();
    }



}
