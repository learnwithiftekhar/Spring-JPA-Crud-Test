package com.learnwithiftekhar.SpringJPACrudTest;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Employee")
@Table(
        name = "employee"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "join_date")
    private LocalDate joinDate;

    public Employee(String name, String email, LocalDate joinDate) {
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
