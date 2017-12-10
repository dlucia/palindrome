package com.mclaren.interview.app;

public class InputValidator implements Validator<String>
{
  @Override public void validate(String value)
  {
    if (value == null || value.isEmpty())
      throw new IllegalArgumentException("Empty string");
  }
}
