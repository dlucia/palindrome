package com.dlucia.palindrome.domain.search.manacher;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ManacherInputConverterTest
{
  private ManacherInputConverter adapter;

  @Before
  public void setUp()
  {
    adapter = new ManacherInputConverter();
  }

  @Test
  public void adaptEvenString()
  {
    String[] actual = adapter.convert("ab");

    assertTrue("Length has to be odd", actual.length % 2 != 0);
    assertThat(actual, is(new String[] { ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR }));
  }

  @Test
  public void adaptOddString()
  {
    String[] actual = adapter.convert("abc");

    assertTrue("Length has to be odd", actual.length % 2 != 0);
    assertThat(actual, is(new String[] { ManacherLongestPalindromes.SEPARATOR, "a", ManacherLongestPalindromes.SEPARATOR, "b", ManacherLongestPalindromes.SEPARATOR, "c", ManacherLongestPalindromes.SEPARATOR }));
  }

  @Test(expected = IllegalArgumentException.class)
  public void inputContainsSeparator()
  {
    adapter.convert("a|c");
  }
}