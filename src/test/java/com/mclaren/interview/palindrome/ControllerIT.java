package com.mclaren.interview.palindrome;

import com.mclaren.interview.palindrome.domain.PalindromeSearch;
import com.mclaren.interview.palindrome.domain.filter.UniquePalindromeFilter;
import com.mclaren.interview.palindrome.domain.search.manacher.ManacherLongestPalindromes;
import com.mclaren.interview.palindrome.domain.strategy.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class ControllerIT
{
  private final Controller controller = new Controller(new InputValidator(),
                                                       new PalindromeSearch(new ManacherLongestPalindromes(),
                                                                            new UniquePalindromeFilter(),
                                                                            new CompositeResultStrategy(new OrderedResultStrategy(
                                                                                OrderedResultStrategy.SortingOrder.DESCENDING),
                                                                                                        new LimitedResultStrategy(3))),
                                                       new ResponseAdapter());

  @Test
  public void acceptanceTest()
  {
    List<PalindromeResponse> response = controller.search("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");

    assertThat(response, contains(new PalindromeResponse("hijkllkjih", 23, 10),
                                  new PalindromeResponse("defggfed", 13, 8),
                                  new PalindromeResponse("abccba", 5, 6)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyInput()
  {
    controller.search("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInput()
  {
    controller.search(null);
  }
}