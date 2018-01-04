package com.dlucia.palindrome.domain.search.manacher;

import com.dlucia.palindrome.domain.model.Palindrome;
import com.dlucia.palindrome.domain.search.LongestPalindromes;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class ManacherLongestPalindromesTest
{
  private LongestPalindromes search;

  @Before
  public void setUp()
  {
    search = new ManacherLongestPalindromes();
  }

  @Test
  public void lengthOneInputIsAPalindrome()
  {
    assertThat(search.in("a"), Matchers.contains(new Palindrome("a", 0, 0)));
    assertThat(search.in("b"), contains(new Palindrome("b", 0, 0)));
  }

  @Test
  public void manyPalindrome()
  {
    assertThat(search.in("aa"), containsInAnyOrder(new Palindrome("a", 0, 0),
                                                   new Palindrome("a", 1, 1),
                                                   new Palindrome("aa", 0, 1)));

    assertThat(search.in("ccc"), containsInAnyOrder(new Palindrome("c", 0, 0),
                                                    new Palindrome("c", 2, 2),
                                                    new Palindrome("cc", 0, 1),
                                                    new Palindrome("cc", 1, 2),
                                                    new Palindrome("ccc", 0, 2)));

    assertThat(search.in("abba"), containsInAnyOrder(new Palindrome("a", 0, 0),
                                                     new Palindrome("b", 1, 1),
                                                     new Palindrome("a", 3, 3),
                                                     new Palindrome("b", 2, 2),
                                                     new Palindrome("abba", 0, 3)));

    assertThat(search.in("aabbaa"), containsInAnyOrder(new Palindrome("aabbaa", 0, 5),
                                                       new Palindrome("aa", 0, 1),
                                                       new Palindrome("aa", 4, 5),
                                                       new Palindrome("a", 0, 0),
                                                       new Palindrome("a", 1, 1),
                                                       new Palindrome("a", 4, 4),
                                                       new Palindrome("a", 5, 5),
                                                       new Palindrome("b", 2, 2),
                                                       new Palindrome("b", 3, 3)));
  }
}
