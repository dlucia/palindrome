package com.mclaren.interview.domain;

import com.mclaren.interview.domain.model.Palindrome;
import com.mclaren.interview.domain.search.LongestPalindromes;
import com.mclaren.interview.domain.strategy.LimitedResultStrategy;
import com.mclaren.interview.domain.strategy.ResultStrategy;

import java.util.List;

import static java.util.Collections.emptyList;

public class PalindromeSearch
{
  private final LongestPalindromes longestPalindromes;
  private final ResultStrategy strategy;

  public PalindromeSearch(LongestPalindromes longestPalindrome, ResultStrategy strategy)
  {
    this.longestPalindromes = longestPalindrome;
    this.strategy = strategy;
  }

  public List<Palindrome> forInput(String input)
  {
    if (input == null || input.isEmpty())
      return emptyList();

    List<Palindrome> palindromes = strategy.applyOn(longestPalindromes.in(input));

    return new LimitedResultStrategy(3).applyOn(palindromes);
  }
}
