package com.dlucia.palindrome.domain.search.manacher;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ManacherLPSCalculatorTest
{
  private ManacherLPSCalculator lpsCalculator;

  @Before
  public void setUp()
  {
    lpsCalculator = new ManacherLPSCalculator();
  }

  @Test
  public void everyCharIsAPalindromeWithLengthOne()
  {
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "a",
                   ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "c",
                   ManacherLongestPalindromes.SEPARATOR, "d", ManacherLongestPalindromes.SEPARATOR, "e",
                   ManacherLongestPalindromes.SEPARATOR, "g", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0 }));
  }

  @Test
  public void singleLongPalindrome()
  {
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 2, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "a",
                   ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR, "c",
                   ManacherLongestPalindromes.SEPARATOR, "d", ManacherLongestPalindromes.SEPARATOR, "e",
                   ManacherLongestPalindromes.SEPARATOR, "e", ManacherLongestPalindromes.SEPARATOR, "d",
                   ManacherLongestPalindromes.SEPARATOR, "c", ManacherLongestPalindromes.SEPARATOR, "b",
                   ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 10, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 }));
  }

  @Test
  public void manyLongPalindrome()
  {
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 2, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { ManacherLongestPalindromes.SEPARATOR, "a",
                   ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR, "c",
                   ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR, "c",
                   ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR, "b",
                   ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR, "c",
                   ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 5, 0, 1, 0, 1, 2, 7, 2, 1, 0, 1, 0, 1, 0 }));
  }
}
