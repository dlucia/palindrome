package com.mclaren.interview;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class PalindromeSearchTest
{
  @Test
  public void noneForEmptyInput()
  {
    PalindromeSearch search = new PalindromeSearch();

    assertThat(search.allIn(""), is(emptyList()));
    assertThat(search.allIn(null), is(emptyList()));
  }

  @Test
  public void lengthOneInputIsAPalindrome()
  {
    PalindromeSearch search = new PalindromeSearch();

    assertThat(search.allIn("a"), contains(new Palindrome("a", 0, 1)));
    assertThat(search.allIn("b"), contains(new Palindrome("b", 0, 1)));
  }
}
