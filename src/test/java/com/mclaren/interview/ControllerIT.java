package com.mclaren.interview;

import com.mclaren.interview.domain.PalindromeSearch;
import com.mclaren.interview.domain.filter.UniquePalindromeFilter;
import com.mclaren.interview.domain.search.manacher.ManacherLongestPalindromes;
import com.mclaren.interview.domain.strategy.*;
import org.junit.Test;

import java.util.List;

import static com.mclaren.interview.domain.strategy.OrderedResultStrategy.SortingOrder.DESCENDING;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class ControllerIT
{
  private final Controller controller = new Controller(new InputValidator(),
                                                       new PalindromeSearch(new ManacherLongestPalindromes(),
                                                                            new UniquePalindromeFilter(),
                                                                            new CompositeResultStrategy(new OrderedResultStrategy(DESCENDING),
                                                                                                        new LimitedResultStrategy(3))),
                                                       new ResponseAdapter());

  @Test
  public void acceptanceTest()
  {
    List<PalindromeResponse> response = controller.execute("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");

    assertThat(response, contains(new PalindromeResponse("hijkllkjih", 23, 10),
                                  new PalindromeResponse("defggfed", 13, 8),
                                  new PalindromeResponse("abccba", 5, 6)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyInput()
  {
    controller.execute("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInput()
  {
    controller.execute(null);
  }
}