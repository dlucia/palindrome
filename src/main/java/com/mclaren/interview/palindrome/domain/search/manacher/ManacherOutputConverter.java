package com.mclaren.interview.palindrome.domain.search.manacher;

import com.mclaren.interview.palindrome.domain.model.Palindrome;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

class ManacherOutputConverter
{
  List<Palindrome> convert(String input, int[] palindromeLengths)
  {
    List<Palindrome> palindromes = new ArrayList<>();

    range(0, palindromeLengths.length).forEach(i -> {
      int length = palindromeLengths[i];
      if (length != 0)
      {
        int init = (i - length) / 2;
        int end = (i + length) / 2 - 1;

        palindromes.add(new Palindrome(input.substring(init, end + 1), init, end));
      }
    });
    return palindromes;
  }
}
