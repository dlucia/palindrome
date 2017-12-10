package com.mclaren.interview.palindrome.domain.filter;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.List;

public interface Filter
{
  List<Palindrome> filter(List<Palindrome> palindromes);
}
