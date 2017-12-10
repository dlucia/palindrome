package com.mclaren.interview.palindrome.domain;

import com.mclaren.interview.palindrome.domain.filter.Filter;
import com.mclaren.interview.palindrome.domain.model.Palindrome;
import com.mclaren.interview.palindrome.domain.search.LongestPalindromes;
import com.mclaren.interview.palindrome.domain.strategy.ResultStrategy;

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
