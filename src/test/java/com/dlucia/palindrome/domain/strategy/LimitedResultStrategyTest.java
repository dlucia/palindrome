package com.dlucia.palindrome.domain.strategy;

import com.dlucia.palindrome.domain.model.Palindrome;
import com.dlucia.palindrome.fixture.PalindromeBuilder;
import org.junit.Test;

import java.util.List;

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
    return PalindromeBuilder.aPalindrome().withValue(value).build();
  }
}