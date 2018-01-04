package com.dlucia.palindrome.domain.strategy;

import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

public class LimitedResultStrategy implements ResultStrategy
{
  private int resultLimit;

  public LimitedResultStrategy(int resultLimit)
  {
    this.resultLimit = resultLimit;
  }

  @Override public List<Palindrome> applyOn(List<Palindrome> palindromes)
  {
    if (palindromes.size() > resultLimit)
      return palindromes.subList(0, resultLimit);

    return palindromes;
  }
}
