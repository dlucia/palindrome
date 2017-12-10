package com.mclaren.interview.domain.search;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public interface LongestPalindromes
{
  List<Palindrome> in(String input);
}
