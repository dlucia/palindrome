package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public class OrderedResultStrategy implements ResultStrategy
{
  private SortingOrder sortingOrder;

  public OrderedResultStrategy(SortingOrder sortingOrder)
  {
    this.sortingOrder = sortingOrder;
  }

  @Override public List<Palindrome> applyOn(List<Palindrome> palindromes)
  {
    if (!sortingOrder.equals(SortingOrder.NONE))
      sort(palindromes);

    return palindromes;
  }

  private void sort(List<Palindrome> palindromes)
  {
    if (sortingOrder.equals(SortingOrder.ASCENDING))
      palindromes.sort((o1, o2) -> {
        if (o1.length() == o2.length())
          return 0;

        return o1.length() < o2.length() ? -1 : 1;
      });
    else
    {
      palindromes.sort((o1, o2) -> {
        if (o1.length() == o2.length())
          return 0;

        return o1.length() > o2.length() ? -1 : 1;
      });
    }
  }

  public enum SortingOrder
  {
    DESCENDING,
    ASCENDING,
    NONE
  }
}
