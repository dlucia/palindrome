package com.dlucia.palindrome.domain.filter;

import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

public interface Filter
{
  List<Palindrome> filter(List<Palindrome> palindromes);
}
