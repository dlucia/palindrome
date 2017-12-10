package com.mclaren.interview.domain.search.manacher;

import static com.mclaren.interview.domain.search.manacher.ManacherLongestPalindromes.SEPARATOR;

class ManacherInputConverter
{
  public String[] convert(String input)
  {
    return input.replaceAll("", SEPARATOR).split("");
  }
}
