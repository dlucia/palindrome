package com.mclaren.interview.palindrome.domain;

import com.mclaren.interview.palindrome.domain.filter.Filter;
import com.mclaren.interview.palindrome.domain.model.Palindrome;
import com.mclaren.interview.palindrome.domain.search.LongestPalindromes;
import com.mclaren.interview.palindrome.domain.strategy.ResultStrategy;
import com.mclaren.interview.palindrome.fixture.PalindromeBuilder;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class PalindromeSearchTest
{
  private static final String STRING = "aString";
  private final Palindrome palindrome1 = PalindromeBuilder.aPalindrome().withValue("a").build();
  private final Palindrome palindrome2 = PalindromeBuilder.aPalindrome().withValue("b").build();
  private final Palindrome palindrome3 = PalindromeBuilder.aPalindrome().withValue("c").build();

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  private LongestPalindromes longestPalindrome;
  @Mock
  private ResultStrategy resultStrategy;
  @Mock
  private Filter uniqueFilter;

  private PalindromeSearch search;

  @Before
  public void setUp()
  {
    search = new PalindromeSearch(longestPalindrome, uniqueFilter, resultStrategy);
  }

  @Test
  public void foundPalindromes()
  {
    context.checking(new Expectations()
    {{
      allowing(longestPalindrome).in(STRING);
      will(returnValue(asList(palindrome1, palindrome2, palindrome3)));

      allowing(uniqueFilter).filter(asList(palindrome1, palindrome2, palindrome3));
      will(returnValue(asList(palindrome1, palindrome2)));

      allowing(resultStrategy).applyOn(asList(palindrome1, palindrome2));
      will(returnValue(singletonList(palindrome2)));
    }});

    assertThat(search.firstThreeFor(STRING), contains(palindrome2));
  }
}
