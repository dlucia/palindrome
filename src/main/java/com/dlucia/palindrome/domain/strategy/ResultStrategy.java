package com.dlucia.palindrome.domain.strategy;

import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

public interface ResultStrategy
{
  List<Palindrome> applyOn(List<Palindrome> palindromes);
}
