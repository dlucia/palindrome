package com.dlucia.palindrome.domain.search.manacher;

import static java.util.stream.IntStream.range;

class ManacherLPSCalculator
{
  int[] lpsArrayFrom(String[] array)
  {
    int[] lsp = new int[array.length];

    range(1, array.length)
        .forEach(i -> lsp[i] = searchPalindromeExpandingFromAGivenPosition(array, i));

    return lsp;
  }

  private int searchPalindromeExpandingFromAGivenPosition(String[] array, int position)
  {
    int leftIndex = position - 1;
    int rightIndex = position + 1;
    int lengthCount = 0;
    if (position % 2 != 0)
      lengthCount++;

    while (expandingRightAndLeft(array, leftIndex, rightIndex))
    {
      lengthCount = incrementPalindromeLength(array[leftIndex], lengthCount);

      leftIndex--;
      rightIndex++;
    }
    return lengthCount;
  }

  private boolean expandingRightAndLeft(String[] array, int leftIndex, int rightIndex)
  {
    if (indexesAreInBoundaries(leftIndex, rightIndex, array.length))
    {
      String leftValue = array[leftIndex];
      String rightValue = array[rightIndex];

      return leftValue.equals(rightValue);
    }
    return false;
  }

  private boolean indexesAreInBoundaries(int leftIndex, int rightIndex, int length)
  {
    return leftIndex >= 0 && rightIndex < length;
  }

  private int incrementPalindromeLength(String value, int lengthCount)
  {
    if (isNotTheSeparator(value))
      lengthCount = lengthCount + 2;

    return lengthCount;
  }

  private boolean isNotTheSeparator(String value)
  {
    return !value.equals(ManacherLongestPalindromes.SEPARATOR);
  }
}
