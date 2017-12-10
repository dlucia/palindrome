package com.mclaren.interview.domain.filter;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;
import java.util.stream.Collectors;

public class UniquePalindromeFilter implements Filter
{
  public List<Palindrome> filter(List<Palindrome> palindromes)
  {
    return palindromes.stream()
        .filter(p -> !isContainedIn(p, palindromes))
        .collect(Collectors.toList());
  }

  private boolean isContainedIn(Palindrome p, List<Palindrome> palindromes)
  {
    return palindromes.stream()
        .filter(palindrome -> !p.equals(palindrome))
        .anyMatch(palindrome -> p.startIndex() >= palindrome.startIndex()
            && p.endIndex() <= palindrome.endIndex());
  }
}
