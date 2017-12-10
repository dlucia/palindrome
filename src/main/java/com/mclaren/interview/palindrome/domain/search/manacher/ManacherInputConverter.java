package com.mclaren.interview.palindrome.domain.search.manacher;

import static java.lang.String.format;

class ManacherInputConverter
{
  public String[] convert(String input)
  {
    if (input.contains(ManacherLongestPalindromes.SEPARATOR))
      throw new IllegalArgumentException(String.format("Search algorithm does not accept %s as valid char", ManacherLongestPalindromes.SEPARATOR));

    return input.replaceAll("", ManacherLongestPalindromes.SEPARATOR).split("");
  }
}
