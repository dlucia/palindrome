package com.mclaren.interview.palindrome.domain.search.manacher;

import com.mclaren.interview.palindrome.domain.model.Palindrome;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class ManacherOutputConverterTest
{
  private ManacherOutputConverter adapter;

  @Before
  public void setUp()
  {
    adapter = new ManacherOutputConverter();
  }

  @Test
  public void adapt()
  {
    assertThat(adapter.convert("abc", new int[] { 0, 1, 0, 1, 0, 1, 0 }),
               Matchers.contains(new Palindrome("a", 0, 0),
                                 new Palindrome("b", 1, 1),
                                 new Palindrome("c", 2, 2)));

    assertThat(adapter.convert("acca", new int[] { 0, 1, 0, 1, 4, 1, 0, 1, 0 }),
               contains(new Palindrome("a", 0, 0),
                        new Palindrome("c", 1, 1),
                        new Palindrome("acca", 0, 3),
                        new Palindrome("c", 2, 2),
                        new Palindrome("a", 3, 3)));
  }
}