package com.mclaren.interview.palindrome.domain.search;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.List;

public interface LongestPalindromes
{
  List<Palindrome> in(String input);
}
