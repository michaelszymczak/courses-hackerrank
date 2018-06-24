package com.michaelszymczak.courses.codility.lessons.lesson001;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import static java.lang.Integer.toBinaryString;

class Solution {
  public int solution(int N) {
    return lengthOfTheLongestGapIn(binaryRepresentationOf(N));
  }

  private char[] binaryRepresentationOf(int N) {
    return toBinaryString(N).toCharArray();
  }

  private int lengthOfTheLongestGapIn(char[] bits) {
    LongestGap result = new LongestGap();
    for (char bit : bits) { if (bit == '0') result.onZero(); else result.onOne(); }

    return result.result();
  }

  private static class LongestGap {
    private boolean encounteredAtLeastOneBitSet = false;
    private int numberOfCurrentConsecutiveZerosThatMayFormAGap = 0;
    private int longestGapFoundSoFar = 0;

    void onZero() {
      if (encounteredAtLeastOneBitSet) {
        numberOfCurrentConsecutiveZerosThatMayFormAGap++;
      }
    }

    void onOne() {
      encounteredAtLeastOneBitSet = true;
      if (numberOfCurrentConsecutiveZerosThatMayFormAGap > longestGapFoundSoFar) {
        longestGapFoundSoFar = numberOfCurrentConsecutiveZerosThatMayFormAGap;
      }
      numberOfCurrentConsecutiveZerosThatMayFormAGap = 0;
    }

    int result() {
      return longestGapFoundSoFar;
    }
  }
}

