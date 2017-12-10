package com.mclaren.interview.domain;

import com.mclaren.interview.domain.filter.Filter;
import com.mclaren.interview.domain.model.Palindrome;
import com.mclaren.interview.domain.search.LongestPalindromes;
import com.mclaren.interview.domain.strategy.ResultStrategy;

import java.util.List;

public class PalindromeSearch
{
  private final LongestPalindromes longest;
  private final Filter filter;
  private final ResultStrategy resultStrategy;

  public PalindromeSearch(LongestPalindromes longestPalindrome,
                          Filter filter,
                          ResultStrategy resultStrategy)
  {
    this.longest = longestPalindrome;
    this.filter = filter;
    this.resultStrategy = resultStrategy;
  }

  public List<Palindrome> firstThreeFor(String input)
  {
    List<Palindrome> found = longest.in(input);
    List<Palindrome> filtered = filter.filter(found);

    return resultStrategy.applyOn(filtered);
  }
}
