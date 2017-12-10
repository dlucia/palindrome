package com.mclaren.interview.palindrome;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.List;
import java.util.stream.Collectors;

class ResponseAdapter implements Adapter<List<Palindrome>, List<PalindromeResponse>>
{
  public List<PalindromeResponse> adapt(List<Palindrome> palindromes)
  {
    return palindromes.stream()
        .map(p -> new PalindromeResponse(p.value(), p.startIndex(), p.length()))
        .collect(Collectors.toList());
  }
}
