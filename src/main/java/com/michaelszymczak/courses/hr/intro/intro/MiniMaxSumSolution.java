package com.michaelszymczak.courses.hr.intro.intro;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.util.Arrays.copyOf;

public class MiniMaxSumSolution {

  /*
   * Complete the miniMaxSum function below.
   */
  static void miniMaxSum(int[] arr) {
    MiniMaxSum miniMaxSum = new MiniMaxSum(arr);
    System.out.println(String.format("%d %d", miniMaxSum.mini(), miniMaxSum.max()));

  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int[] arr = new int[5];

    String[] arrItems = scan.nextLine().split(" ");

    for (int arrItr = 0; arrItr < 5; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      arr[arrItr] = arrItem;
    }

    miniMaxSum(arr);
  }

  static class MiniMaxSum {

    private final int[] arr;

    public MiniMaxSum(int[] arr) {
      this.arr = copyOf(arr, arr.length);
    }

    public long mini() {
      long result = 0;
      int maxSoFar = MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
        if (i < arr.length - 1) {
          result += arr[i];
          if (maxSoFar < arr[i]) {
            maxSoFar = arr[i];
          }
        } else {
          if (maxSoFar > arr[i]) {
            result = result - maxSoFar + arr[i];
          }
        }
      }

      return result;
    }

    public long max() {
      long result = 0;
      for (int i = 0; i < arr.length - 1; i++) {
        result += arr[i];
      }

      return result;
    }
  }
}
