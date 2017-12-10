package com.mclaren.interview.palindrome.domain.strategy;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.List;

public interface ResultStrategy
{
  List<Palindrome> applyOn(List<Palindrome> palindromes);
}
