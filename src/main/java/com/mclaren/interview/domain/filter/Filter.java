package com.mclaren.interview.domain.filter;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public interface Filter
{
  List<Palindrome> filter(List<Palindrome> palindromes);
}
