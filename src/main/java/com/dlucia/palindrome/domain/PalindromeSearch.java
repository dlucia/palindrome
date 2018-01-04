package com.dlucia.palindrome.domain;

import com.dlucia.palindrome.domain.filter.Filter;
import com.dlucia.palindrome.domain.search.LongestPalindromes;
import com.dlucia.palindrome.domain.model.Palindrome;
import com.dlucia.palindrome.domain.strategy.ResultStrategy;

import java.util.List;

public class PalindromeSearch
{
  private final LongestPalindromes longest;
  private final Filter uniqueFilter;
  private final ResultStrategy resultStrategy;

  public PalindromeSearch(LongestPalindromes longestPalindrome,
                          Filter uniqueFilter,
                          ResultStrategy resultStrategy)
  {
    this.longest = longestPalindrome;
    this.uniqueFilter = uniqueFilter;
    this.resultStrategy = resultStrategy;
  }

  public List<Palindrome> firstThreeFor(String input)
  {
    List<Palindrome> found = longest.in(input);
    List<Palindrome> filtered = uniqueFilter.filter(found);

    return resultStrategy.applyOn(filtered);
  }
}
