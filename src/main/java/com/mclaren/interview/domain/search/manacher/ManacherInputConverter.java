package com.mclaren.interview.domain.search.manacher;

import static com.mclaren.interview.domain.search.manacher.ManacherLongestPalindromes.SEPARATOR;
import static java.lang.String.format;

class ManacherInputConverter
{
  public String[] convert(String input)
  {
    if (input.contains(SEPARATOR))
      throw new IllegalArgumentException(format("Search algorithm does not accept %s as valid char", SEPARATOR));

    return input.replaceAll("", SEPARATOR).split("");
  }
}
