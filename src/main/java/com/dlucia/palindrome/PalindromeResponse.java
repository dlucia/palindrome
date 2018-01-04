package com.dlucia.palindrome;

import java.util.Objects;

public class PalindromeResponse
{
  private String text;
  private int index;
  private int length;

  PalindromeResponse(String text, int index, int length)
  {
    this.text = text;
    this.index = index;
    this.length = length;
  }

  @Override public String toString()
  {
    return "text='" + text +
        ", index=" + index +
        ", length=" + length;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PalindromeResponse that = (PalindromeResponse) o;
    return index == that.index &&
        length == that.length &&
        Objects.equals(text, that.text);
  }

  @Override public int hashCode()
  {
    return Objects.hash(text, index, length);
  }
}
