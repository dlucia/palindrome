package com.dlucia.palindrome;

public interface Adapter<IN, OUT>
{
  OUT adapt(IN palindromes);
}
