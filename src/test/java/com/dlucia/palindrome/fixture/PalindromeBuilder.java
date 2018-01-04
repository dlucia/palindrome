package com.dlucia.palindrome.fixture;

import com.dlucia.palindrome.domain.model.Palindrome;

public class PalindromeBuilder
{
  private String value = "";
  private int startIndex = 0;
  private int endIndex = 0;

  private PalindromeBuilder() {}

  public static PalindromeBuilder aPalindrome()
  {
    return new PalindromeBuilder();
  }

  public PalindromeBuilder withStartIndex(int startIndex)
  {
    this.startIndex = startIndex;
    return this;
  }

  public PalindromeBuilder withEndIndex(int endIndex)
  {
    this.endIndex = endIndex;
    return this;
  }

  public PalindromeBuilder withValue(String value)
  {
    this.value = value;
    return this;
  }

  public Palindrome build()
  {
    return new Palindrome(value, startIndex, endIndex);
  }
}
