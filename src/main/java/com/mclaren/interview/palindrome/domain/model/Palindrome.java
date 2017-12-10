package com.mclaren.interview.palindrome.domain.model;

import java.util.Objects;

public class Palindrome
{
  private final String value;
  private final int startIndex;
  private final int endIndex;

  public Palindrome(String value, int startIndex, int endIndex)
  {
    this.value = value;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  public String value()
  {
    return value;
  }

  public int startIndex()
  {
    return startIndex;
  }

  public int endIndex()
  {
    return endIndex;
  }

  public int length()
  {
    return value.length();
  }

  @Override public String toString()
  {
    return "Palindrome{" +
        "value='" + value + '\'' +
        ", length=" + length() +
        ", startIndex=" + startIndex +
        ", endIndex=" + endIndex +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Palindrome that = (Palindrome) o;
    return startIndex == that.startIndex &&
        endIndex == that.endIndex &&
        Objects.equals(value, that.value);
  }

  @Override public int hashCode()
  {

    return Objects.hash(value, startIndex, endIndex);
  }
}
