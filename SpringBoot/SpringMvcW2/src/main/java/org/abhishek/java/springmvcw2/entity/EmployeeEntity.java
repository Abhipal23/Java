package org.abhishek.java.springmvcw2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity   // @Entity is annotation used tells jpa provider(hybernate) that you need to convert this table class into table in database
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private Integer  age;
    private LocalDate dateOfJoining;
    private Boolean isActive;
    private String role;
    private Double salary;


}
