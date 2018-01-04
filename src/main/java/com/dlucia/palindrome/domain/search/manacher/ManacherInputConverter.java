package com.dlucia.palindrome.domain.search.manacher;

class ManacherInputConverter
{
  public String[] convert(String input)
  {
    if (input.contains(ManacherLongestPalindromes.SEPARATOR))
      throw new IllegalArgumentException(String.format("Search algorithm does not accept %s as valid char", ManacherLongestPalindromes.SEPARATOR));

    return input.replaceAll("", ManacherLongestPalindromes.SEPARATOR).split("");
  }
}
