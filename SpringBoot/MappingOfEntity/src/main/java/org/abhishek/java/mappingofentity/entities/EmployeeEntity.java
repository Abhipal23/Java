package org.abhishek.java.mappingofentity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;
    // it won't create another col in employeeEntity
    // as we difine in departmet that each departmet have one manger but here employee doest have information who is managing whcihc departmet



    @ManyToOne  (cascade = CascadeType.ALL)                               // bydefault it will mapped to id only
    @JoinColumn(name = "worker_department_id", referencedColumnName = "id")
    @JsonIgnore
    private  DepartmentEntity workerDepartment;



    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "freelanncer_department_mapping",joinColumns = @JoinColumn(name = "employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")

    )
    @JsonIgnore

    private Set< DepartmentEntity > freelanceDepartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
