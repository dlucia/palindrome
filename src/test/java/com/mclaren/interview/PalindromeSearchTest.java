package com.mclaren.interview;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeSearchTest
{
  @Test
  public void noneForEmptyInput()
  {
    PalindromeSearch search = new PalindromeSearch();

    assertThat(search.firstLongestThreeIn(""), is(emptyList()));
    assertThat(search.firstLongestThreeIn(null), is(emptyList()));
  }

  @Test
  public void lengthOneInputIsAPalindrome()
  {
    PalindromeSearch search = new PalindromeSearch();

    assertThat(search.firstLongestThreeIn("a"), is(singletonList(new Palindrome("a", 0, 1))));
    assertThat(search.firstLongestThreeIn("b"), is(singletonList(new Palindrome("b", 0, 1))));
  }
}
