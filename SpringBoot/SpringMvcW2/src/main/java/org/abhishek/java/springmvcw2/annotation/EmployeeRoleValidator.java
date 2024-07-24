package org.abhishek.java.springmvcw2.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
//    @Override
//    public void initialize(EmployeeRoleValidation constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {

        if (inputRole == null) return false;
        List<String> roles = List.of("USER","ADMIN");

        return roles.contains(inputRole);
    }
}
