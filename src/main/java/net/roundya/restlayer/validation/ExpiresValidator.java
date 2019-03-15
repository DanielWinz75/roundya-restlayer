package net.roundya.restlayer.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.roundya.restlayer.place.PlaceConstants;

public class ExpiresValidator implements ConstraintValidator<ExpiresConstraint, Date> {

  @Override
  public void initialize(ExpiresConstraint secs) {
  }

  @Override
  public boolean isValid(Date reqExpDate, ConstraintValidatorContext cxt) {

    long offsetSecs = (reqExpDate.getTime() - Instant.now().toEpochMilli()) / 1000;
    long min = PlaceConstants.TIME_TO_LIVE_MIN;
    long max = PlaceConstants.TIME_TO_LIVE_MAX;
    if (offsetSecs < min || offsetSecs > max)
      return false;

    return true;
  }
}
