package com.mclaren.interview;

import com.mclaren.interview.domain.PalindromeSearch;
import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

/*
    This is not strictly part of the solution. I put it just to compose the Palindrome Search Use Case
    and to expose it through an API. It can be whatever: e.g. a Rest Controller)

    The use case can be composed with any other palindrome search algorithm and with different result strategy
    I Implemented the most efficient (with linear complexity O(n)) Manacher’s Algorithm
 */
public class Controller
{
  private final PalindromeSearch search;
  private final Validator<String> validator;
  private final Adapter<List<Palindrome>, List<PalindromeResponse>> responseAdapter;

  Controller(Validator<String> validator,
             PalindromeSearch search,
             Adapter<List<Palindrome>, List<PalindromeResponse>> responseAdapter)
  {
    this.search = search;
    this.validator = validator;
    this.responseAdapter = responseAdapter;
  }

  public List<PalindromeResponse> execute(String input)
  {
    validator.validate(input);

    List<Palindrome> foundPalindromes = search.firstThreeFor(input);

    return responseAdapter.adapt(foundPalindromes);
  }
}
