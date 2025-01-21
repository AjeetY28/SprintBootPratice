package com.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {PrimeNoValidator.class})
public @interface PrimeNoValidation {
    String message() default "Resource is not Prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}