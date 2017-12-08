package com.mclaren.interview;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeSearchTest
{
  @Test
  public void noneForEmptyInput()
  {
    
    PalindromeSearch search = new PalindromeSearch();
    assertThat(search.firstThreeIn(""), is(emptyList()));
    assertThat(search.firstThreeIn(null), is(emptyList()));
  }
}
