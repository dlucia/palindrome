package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.filter.Filter;
import com.mclaren.interview.domain.filter.UniquePalindromeFilter;
import com.mclaren.interview.domain.model.Palindrome;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class UniqueResultStrategyTest
{
  private Filter filter;

  @Before
  public void setUp()
  {
    filter = new UniquePalindromeFilter();
  }

  @Test
  public void unique()
  {
    List<Palindrome> unique = filter.filter(asList(new Palindrome("a", 0, 0),
                                                   new Palindrome("b", 1, 1),
                                                   new Palindrome("a", 3, 3),
                                                   new Palindrome("b", 2, 2),
                                                   new Palindrome("abba", 0, 3)));

    assertThat(unique, contains(new Palindrome("abba", 0, 3)));
  }

  @Test
  public void multipleUnique()
  {
    List<Palindrome> unique = filter.filter(asList(new Palindrome("aca", 3, 5),
                                                   new Palindrome("aba", 0, 2)));

    assertThat(unique, containsInAnyOrder(new Palindrome("aca", 3, 5),
                                          new Palindrome("aba", 0, 2)));
  }

}