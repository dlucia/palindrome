package com.mclaren.interview.palindrome.domain.strategy;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.List;
import java.util.stream.Collectors;

public class UniqueResultStrategy implements ResultStrategy
{
  @Override public List<Palindrome> applyOn(List<Palindrome> palindromes)
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
