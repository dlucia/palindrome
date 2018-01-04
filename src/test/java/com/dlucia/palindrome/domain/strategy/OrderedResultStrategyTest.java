package com.dlucia.palindrome.domain.strategy;

import com.dlucia.palindrome.domain.model.Palindrome;
import com.dlucia.palindrome.fixture.PalindromeBuilder;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.dlucia.palindrome.domain.strategy.OrderedResultStrategy.SortingOrder.*;
import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class OrderedResultStrategyTest
{
  @Test
  public void sortAscending()
  {
    ResultStrategy strategy = new OrderedResultStrategy(ASCENDING);

    List<Palindrome> ordered = strategy.applyOn(asList(aPalindromeWithLength(4),
                                                       aPalindromeWithLength(3),
                                                       aPalindromeWithLength(3),
                                                       aPalindromeWithLength(2)));

    assertThat(ordered, contains(aPalindromeWithLength(2),
                                 aPalindromeWithLength(3),
                                 aPalindromeWithLength(3),
                                 aPalindromeWithLength(4)));
  }

  @Test
  public void sortDescending()
  {
    ResultStrategy strategy = new OrderedResultStrategy(DESCENDING);

    List<Palindrome> ordered = strategy.applyOn(asList(aPalindromeWithLength(4),
                                                       aPalindromeWithLength(3),
                                                       aPalindromeWithLength(2),
                                                       aPalindromeWithLength(2)));

    assertThat(ordered, contains(aPalindromeWithLength(4),
                                 aPalindromeWithLength(3),
                                 aPalindromeWithLength(2),
                                 aPalindromeWithLength(2)));
  }

  @Test
  public void noSorting()
  {
    ResultStrategy strategy = new OrderedResultStrategy(NONE);

    List<Palindrome> ordered = strategy.applyOn(asList(aPalindromeWithLength(4),
                                                       aPalindromeWithLength(5),
                                                       aPalindromeWithLength(2)));

    assertThat(ordered, contains(aPalindromeWithLength(4),
                                 aPalindromeWithLength(5),
                                 aPalindromeWithLength(2)));
  }

  private Palindrome aPalindromeWithLength(int length)
  {
    String value = range(0, length).mapToObj(i -> "a").collect(Collectors.joining());

    return PalindromeBuilder.aPalindrome().withValue(value).build();
  }
}