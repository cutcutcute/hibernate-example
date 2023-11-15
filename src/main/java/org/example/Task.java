package org.example;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="task_name")
    public String taskName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    public User user;
    @Column(name = "deadline")
    public Date deadline;


}
