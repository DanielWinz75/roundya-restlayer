package net.roundya.restlayer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.roundya.restlayer.place.PlaceConstants;

public class PredicateValidator implements ConstraintValidator<PredicateConstraint, String> {

  @Override
  public void initialize(PredicateConstraint contactNumber) {
  }

  @Override
  public boolean isValid(String predicate, ConstraintValidatorContext cxt) {
    return PlaceConstants.PREDICATES.contains(predicate);
  }
}
