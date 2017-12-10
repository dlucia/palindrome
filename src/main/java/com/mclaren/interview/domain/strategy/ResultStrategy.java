package com.mclaren.interview.domain.strategy;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public interface ResultStrategy
{
  List<Palindrome> applyOn(List<Palindrome> palindromes);
}
