package com.michaelszymczak.courses.codility.lessons.lesson002;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import static java.lang.System.arraycopy;

class Solution {
  public int[] solution(int[] A, int K) {
    return new Rotation(A.length, K).rotated(A);
  }

  private static class Rotation {

    final int sizeOfTheWholeArray;
    final int numberOfElementsMovedToStart;
    final int numberOfRemainingElements;
    final int positionOfTheFirstElementThatWillBeMovedToStart;

    public Rotation(int sizeOfTheWholeArray, int rotation) {
      this.sizeOfTheWholeArray = sizeOfTheWholeArray;
      this.numberOfElementsMovedToStart = sizeOfTheWholeArray > 0 ? rotation % sizeOfTheWholeArray : 0;
      this.numberOfRemainingElements = sizeOfTheWholeArray - numberOfElementsMovedToStart;
      this.positionOfTheFirstElementThatWillBeMovedToStart = sizeOfTheWholeArray - numberOfElementsMovedToStart;
    }

    public int[] rotated(int[] input) {
      if (input.length != sizeOfTheWholeArray) {
        throw new IllegalArgumentException("Invalid input array length");
      }

      final int[] result = new int[sizeOfTheWholeArray];
      copyRotated(input, result);
      copyRemaining(input, result);

      return result;
    }

    private void copyRemaining(int[] input, int[] result) {
      arraycopy(input, 0, result, numberOfElementsMovedToStart, numberOfRemainingElements);
    }

    private void copyRotated(int[] input, int[] result) {
      arraycopy(input, positionOfTheFirstElementThatWillBeMovedToStart, result, 0, numberOfElementsMovedToStart);
    }
  }
}