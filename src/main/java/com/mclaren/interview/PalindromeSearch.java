package com.mclaren.interview;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class PalindromeSearch
{
  public List<Palindrome> allIn(String input)
  {
    if (input == null || input.isEmpty())
      return emptyList();

    return asList(new Palindrome(input, 0, input.length()));
  }
}
