package com.dlucia.palindrome;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest
{
  private InputValidator inputValidator;

  @Before
  public void setUp()
  {
    inputValidator = new InputValidator();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyInput()
  {
    inputValidator.validate("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInput()
  {
    inputValidator.validate(null);
  }
}