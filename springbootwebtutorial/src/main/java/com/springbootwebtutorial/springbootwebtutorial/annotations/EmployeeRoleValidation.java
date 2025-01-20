package com.springbootwebtutorial.springbootwebtutorial.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
    String message() default "Role of Employee can be USER or ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
