package edu.deegrework.StudentManagementSystem.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneValidation, String> {

    static final String COUNTRY_CODE = "994";
    static final Integer NUMBER_LENGTH = 12;

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        try {
            Long.parseLong(phone);
        }catch(NumberFormatException e){
            return false;
        }
        return phone.length() == NUMBER_LENGTH && phone.substring(0,3).contains(COUNTRY_CODE);
    }
}
