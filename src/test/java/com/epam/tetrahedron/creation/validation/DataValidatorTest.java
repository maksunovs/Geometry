package com.epam.tetrahedron.creation.validation;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {
  private  DataValidator dataValidator = new DataValidator();
  private final String validData = "12.0 -12.0 +34.0 10     ";
  private final String letterSupplied = "12.0 1z.0 34.0 10.0";
  private final String zeroLength = "12.0 12.0 34.0 -10.0";
    @Test
    public void ShouldBeValid() {
        boolean result = dataValidator.isValid(validData);
        Assert.assertTrue(result);
    }

    @Test
    public void ShouldBeInvalidWhenLetterSupplied(){
        boolean result = dataValidator.isValid(letterSupplied);
        Assert.assertFalse(result);
    }

    @Test
    public void ShouldBeInvalidWhenNegativeLength(){
        boolean result = dataValidator.isValid(zeroLength);
        Assert.assertFalse(result);
    }
}