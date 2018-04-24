package com.michaelszymczak.courses.hr.intro.intro;

import java.util.Scanner;

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

    public MiniMaxSum(int[] arr) {
    }

    public int max() {
      return 0;
    }

    public int mini() {
      return 0;
    }
  }
}
