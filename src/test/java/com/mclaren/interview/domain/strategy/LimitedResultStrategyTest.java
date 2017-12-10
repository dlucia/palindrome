package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.model.Palindrome;
import org.junit.Test;

import java.util.List;

import static com.mclaren.interview.fixture.PalindromeBuilder.aPalindrome;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class LimitedResultStrategyTest
{
  @Test
  public void limitResults()
  {
    ResultStrategy strategy = new LimitedResultStrategy(2);

    List<Palindrome> ordered = strategy.applyOn(asList(aPalindromeWithValue("aa"),
                                                       aPalindromeWithValue("sd"),
                                                       aPalindromeWithValue("cd")));

    assertThat(ordered, contains(aPalindromeWithValue("aa"),
                                 aPalindromeWithValue("sd")));
  }

  @Test
  public void limitIsGreaterThenResults()
  {
    ResultStrategy strategy = new LimitedResultStrategy(4);

    List<Palindrome> ordered = strategy.applyOn(asList(aPalindromeWithValue("aa"),
                                                       aPalindromeWithValue("sd"),
                                                       aPalindromeWithValue("cd")));

    assertThat(ordered, contains(aPalindromeWithValue("aa"),
                                 aPalindromeWithValue("sd"),
                                 aPalindromeWithValue("cd")));
  }

  private Palindrome aPalindromeWithValue(String value)
  {
    return aPalindrome().withValue(value).build();
  }
}