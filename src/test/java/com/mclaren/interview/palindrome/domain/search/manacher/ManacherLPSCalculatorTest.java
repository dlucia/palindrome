package com.mclaren.interview.palindrome.domain.search.manacher;

import org.junit.Before;
import org.junit.Test;

import static com.mclaren.interview.palindrome.domain.search.manacher.ManacherLongestPalindromes.SEPARATOR;
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
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "a",
                   SEPARATOR, "b", SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "c",
                   SEPARATOR, "d", SEPARATOR, "e",
                   SEPARATOR, "g", SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0 }));
  }

  @Test
  public void singleLongPalindrome()
  {
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "a", SEPARATOR, "a", SEPARATOR }),
               is(new int[] { 0, 1, 2, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "a",
                   SEPARATOR, "b", SEPARATOR, "c",
                   SEPARATOR, "d", SEPARATOR, "e",
                   SEPARATOR, "e", SEPARATOR, "d",
                   SEPARATOR, "c", SEPARATOR, "b",
                   SEPARATOR, "a", SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 10, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 }));
  }

  @Test
  public void manyLongPalindrome()
  {
    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "a", SEPARATOR, "a", SEPARATOR }),
               is(new int[] { 0, 1, 2, 1, 0 }));

    assertThat(lpsCalculator.lpsArrayFrom(new String[] { SEPARATOR, "a",
                   SEPARATOR, "b", SEPARATOR, "c",
                   SEPARATOR, "a", SEPARATOR, "c",
                   SEPARATOR, "b", SEPARATOR, "b",
                   SEPARATOR, "b", SEPARATOR, "c",
                   SEPARATOR, "a", SEPARATOR }),
               is(new int[] { 0, 1, 0, 1, 0, 1, 0, 5, 0, 1, 0, 1, 2, 7, 2, 1, 0, 1, 0, 1, 0 }));
  }
}
