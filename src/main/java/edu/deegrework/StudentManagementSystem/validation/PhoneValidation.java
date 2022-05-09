package edu.deegrework.StudentManagementSystem.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface PhoneValidation {

    public String message() default "Invalid phone number. It contains COUNTRY_CODE and length must be 12";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
