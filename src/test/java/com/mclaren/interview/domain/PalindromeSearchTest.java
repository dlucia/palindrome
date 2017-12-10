package com.mclaren.interview.domain;

import com.mclaren.interview.domain.model.Palindrome;
import com.mclaren.interview.domain.PalindromeSearch;
import com.mclaren.interview.domain.search.LongestPalindromes;
import com.mclaren.interview.domain.strategy.ResultStrategy;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import static com.mclaren.interview.fixture.PalindromeBuilder.aPalindrome;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class PalindromeSearchTest
{
  private static final String STRING = "aString";
  private final Palindrome palindrome1 = aPalindrome().withValue("a").build();
  private final Palindrome palindrome2 = aPalindrome().withValue("b").build();
  private final Palindrome palindrome3 = aPalindrome().withValue("c").build();

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  private LongestPalindromes longestPalindrome;
  @Mock
  private ResultStrategy resultStrategy;

  private PalindromeSearch search;

  @Before
  public void setUp()
  {
    search = new PalindromeSearch(longestPalindrome, resultStrategy);
  }

  @Test
  public void noneForEmptyInput()
  {
    assertThat(search.forInput(""), is(emptyList()));
    assertThat(search.forInput(null), is(emptyList()));
  }

  @Test
  public void foundPalindromesAndFiltrated()
  {
    context.checking(new Expectations()
    {{
      allowing(longestPalindrome).in(STRING);
      will(returnValue(asList(palindrome1, palindrome2, palindrome3)));

      allowing(resultStrategy).applyOn(asList(palindrome1, palindrome2, palindrome3));
      will(returnValue(singletonList(palindrome2)));
    }});

    assertThat(search.forInput(STRING), contains(palindrome2));
  }
}
