package com.mclaren.interview.app;

import com.mclaren.interview.domain.PalindromeSearch;
import com.mclaren.interview.domain.model.Palindrome;
import com.mclaren.interview.domain.search.manacher.ManacherLongestPalindromes;
import com.mclaren.interview.domain.strategy.*;

import java.util.List;
import java.util.Scanner;

import static com.mclaren.interview.domain.strategy.OrderedResultStrategy.SortingOrder.DESCENDING;
import static java.util.Arrays.asList;

/*
    This is not strictly part of the solution. I put it just to compose the Palindrome Search Use Case
    and to expose it through an API (an old fashioned console one, just as example :). It can be whatever: e.g. a Rest Controller)

    The use case can be composed with any other palindrome search algorithm and with different result strategy
    I Implemented the most efficient (with linear complexity O(n)) Manacher’s Algorithm
 */
public class ConsoleController
{
  private static final PalindromeSearch search =
      new PalindromeSearch(new ManacherLongestPalindromes(),
                           new CompositeResultStrategy(asList(new UniqueResultStrategy(),
                                                              new OrderedResultStrategy(DESCENDING))));
  private static final Validator<String> validator = new InputValidator();

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    String input = in.nextLine();
    validator.validate(input);

    List<Palindrome> foundPalindromes = search.forInput(input);
    foundPalindromes.forEach(System.out::println);
  }
}
