package com.dlucia.palindrome.domain.search.manacher;

import com.dlucia.palindrome.domain.search.LongestPalindromes;
import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

public class ManacherLongestPalindromes implements LongestPalindromes
{
  static final String SEPARATOR = "|";
  private final ManacherInputConverter inputConverter;
  private final ManacherOutputConverter outputConverter;
  private final ManacherLPSCalculator lpsCalculator;

  public ManacherLongestPalindromes()
  {
    this.inputConverter = new ManacherInputConverter();
    this.lpsCalculator = new ManacherLPSCalculator();
    this.outputConverter = new ManacherOutputConverter();
  }

  @Override public List<Palindrome> in(String input)
  {
    String[] manacherArray = inputConverter.convert(input);

    int[] lpsArray = lpsCalculator.lpsArrayFrom(manacherArray);

    return outputConverter.convert(input, lpsArray);
  }

}
