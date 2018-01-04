package com.dlucia.palindrome;

import com.dlucia.palindrome.domain.PalindromeSearch;
import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

/*
    This is a generic controller which expose the use case API. It can be whatever: e.g. a Rest Controller)
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

  public List<PalindromeResponse> search(String input)
  {
    validator.validate(input);

    List<Palindrome> foundPalindromes = search.firstThreeFor(input);

    return responseAdapter.adapt(foundPalindromes);
  }
}
