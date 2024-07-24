package org.abhishek.java.springmvcw2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.abhishek.java.springmvcw2.annotation.EmployeeRoleValidation;

import java.time.LocalDate;

// POJIO CLASS TO DEFINE
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private   long id;
    @NotBlank(message = "Required filed in Employee: nane ")
    // along with we have to inform to controller to validate dto  @valid annotation
    private String name;

    @NotBlank(message = "Email of employee cannot be blank")
    @Email(message = "email should valid email")
    private String email;

    @Max(value = 80,message = "Age should less than 80")
    @Min(value = 18, message = "minimum age should be 18")
    private Integer  age;


    @NotBlank(message = "role of employee can't blank")
//    @Pattern(regexp = "^(ADMIN|USER)$" , message = "role of employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private  String role;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;
    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "isActive should be true ")
    private Boolean isActive;


    // to expose them we will define getter and setter



}
