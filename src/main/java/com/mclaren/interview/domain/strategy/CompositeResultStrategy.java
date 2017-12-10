package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public class CompositeResultStrategy implements ResultStrategy
{
  private final List<ResultStrategy> resultStrategies;

  public CompositeResultStrategy(List<ResultStrategy> resultStrategies)
  {
    this.resultStrategies = resultStrategies;
  }

  @Override public List<Palindrome> applyOn(List<Palindrome> palindromes)
  {
    List<Palindrome> list = palindromes;
    for (ResultStrategy resultStrategy : resultStrategies)
      list = resultStrategy.applyOn(list);

    return list;
  }
}
