package com.secondSpringBootProject.curdOperation.firstPojectCurd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fname;

    @Column
    private String lname;
    @Column
    private String emailId;
}
