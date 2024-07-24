package org.abhishek.java.springmvcw2.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = EmployeeRoleValidator.class)
// inside dto all are fileds
public @interface EmployeeRoleValidation {


    // here we can pass some default message
    String message() default "Role  can be ADMIN | USER ";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
