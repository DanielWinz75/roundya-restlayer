package net.roundya.restlayer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.roundya.restlayer.place.PlaceConstants;

public class SubjectValidator implements
  ConstraintValidator<SubjectConstraint, String> {
 
  @Override
    public void initialize(SubjectConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String subject,
      ConstraintValidatorContext cxt) {
        return PlaceConstants.SUBJECTS.contains(subject);
  }
}
