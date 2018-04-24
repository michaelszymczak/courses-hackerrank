package com.michaelszymczak.courses.hr.intro.intro;

import java.util.Scanner;

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
      return sum(true);
    }

    public long max() {
      return sum(false);
    }

    private long sum(boolean isMini) {
      final State state = new State();
      for (int i = 0; i < arr.length; i++) {
        state.add(isLastElement(i) ? state.appropriateValue(isMini, arr[i]) : arr[i]);
        state.accept(arr[i]);
      }

      return state.sumSoFar();
    }

    private boolean isLastElement(int i) {
      return i == arr.length - 1;
    }
  }

  private static class State {
    private int minSoFar = Integer.MAX_VALUE;
    private int maxSoFar = Integer.MIN_VALUE;
    private long sumSoFar = 0;

    void add(int value) {
      sumSoFar += value;
    }

    void accept(int value) {
      if (minSoFar > value) {
        minSoFar = value;
      }
      if (maxSoFar < value) {
        maxSoFar = value;
      }
    }

    int appropriateValue(boolean isMini, int value) {
      if (isMini && maxSoFar > value) return value - maxSoFar;
      if (!isMini && minSoFar < value) return value - minSoFar;

      return 0;
    }

    public long sumSoFar() {
      return sumSoFar;
    }
  }

}
