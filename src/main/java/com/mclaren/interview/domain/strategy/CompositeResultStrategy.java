package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public class CompositeResultStrategy implements ResultStrategy
{
  private final ResultStrategy orderedStrategy;
  private final ResultStrategy limitedStrategy;

  public CompositeResultStrategy(ResultStrategy orderedStrategy, ResultStrategy limitedStrategy)
  {
    this.orderedStrategy = orderedStrategy;
    this.limitedStrategy = limitedStrategy;
  }

  @Override public List<Palindrome> applyOn(List<Palindrome> palindromes)
  {
    List<Palindrome> ordered = orderedStrategy.applyOn(palindromes);

    return limitedStrategy.applyOn(ordered);
  }
}
