package com.epam.tetrahedron.creation.validation;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {
  private  DataValidator dataValidator = new DataValidator();
  private static final String VALID_DATA = "12.0 -12.0 +34.0 10     ";
  private static final String LETTER_SUPPLIED = "12.0 1z.0 34.0 10.0";
  private static final String NEGATIVE_LENGTH = "12.0 12.0 34.0 -10.0";
    @Test
    public void ShouldBeValid() {
        boolean result = dataValidator.isValid(VALID_DATA);
        Assert.assertTrue(result);
    }

    @Test
    public void ShouldBeInvalidWhenLetterSupplied(){
        boolean result = dataValidator.isValid(LETTER_SUPPLIED);
        Assert.assertFalse(result);
    }

    @Test
    public void ShouldBeInvalidWhenNegativeLength(){
        boolean result = dataValidator.isValid(NEGATIVE_LENGTH);
        Assert.assertFalse(result);
    }
}