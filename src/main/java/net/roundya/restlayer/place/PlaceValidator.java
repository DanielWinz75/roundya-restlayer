package net.roundya.restlayer.place;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PlaceValidator implements
  ConstraintValidator<PredicateConstraint, String> {
 
  @Override
    public void initialize(PredicateConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String predicate,
      ConstraintValidatorContext cxt) {
        return PlaceConstants.PREDICATES.contains(predicate);
  }
}
