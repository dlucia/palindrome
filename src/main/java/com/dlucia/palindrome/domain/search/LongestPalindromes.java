package com.dlucia.palindrome.domain.search;

import com.dlucia.palindrome.domain.model.Palindrome;

import java.util.List;

public interface LongestPalindromes
{
  List<Palindrome> in(String input);
}
