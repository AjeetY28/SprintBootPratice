package com.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNoValidator implements ConstraintValidator<PrimeNoValidation,Integer> {
    @Override
    public boolean isValid(Integer inputValue, ConstraintValidatorContext constraintValidatorContext) {
        if (inputValue==null||inputValue <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(inputValue); i++) {
            if (inputValue % i == 0) {
                return false;
            }
        }
        return true;

    }
}
