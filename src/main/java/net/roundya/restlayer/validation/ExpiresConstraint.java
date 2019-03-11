package net.roundya.restlayer.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = ExpiresValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExpiresConstraint {
    String message() default "Difference of date-now and date-requested must be between 3600secs (1 hour) and 259200secs (3 days).";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}