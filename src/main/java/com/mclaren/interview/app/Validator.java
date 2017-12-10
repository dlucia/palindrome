package com.mclaren.interview.app;

public interface Validator<VALUE>
{
  void validate(VALUE value);
}
