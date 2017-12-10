package com.mclaren.interview.app;

import com.mclaren.interview.domain.model.Palindrome;

import java.util.List;

public class ResponseAdapter implements Adapter<List<Palindrome>, List<PalindromeDTO>>
{
  @Override public List<PalindromeDTO> convert(List<Palindrome> palindrome)
  {
    return null;

  }
}
