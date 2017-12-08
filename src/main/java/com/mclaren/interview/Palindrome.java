package com.mclaren.interview;

import java.util.Objects;

public class Palindrome
{
  private final String value;
  private final int startIndex;
  private final int length;

  Palindrome(String value, int startIndex, int length)
  {
    this.value = value;
    this.startIndex = startIndex;
    this.length = length;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Palindrome that = (Palindrome) o;
    return startIndex == that.startIndex &&
        length == that.length &&
        Objects.equals(value, that.value);
  }

  @Override public int hashCode()
  {
    return Objects.hash(value, startIndex, length);
  }
}
