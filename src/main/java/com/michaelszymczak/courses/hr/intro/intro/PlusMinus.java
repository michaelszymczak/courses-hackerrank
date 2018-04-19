package com.michaelszymczak.courses.hr.intro.intro;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PlusMinus {

  private static class Count {
    private int positive = 0;
    private int negative = 0;
    private int zero = 0;
    private int all = 0;

    void value(int v) {
      if (v > 0) positive++;
      if (v < 0) negative++;
      if (v == 0) zero++;
      all++;
    }

    double positiveRatio() {
      return ratioOf(positive);
    }


    double negativeRatio() {
      return ratioOf(negative);
    }

    double zeroRatio() {
      return ratioOf(zero);
    }

    private double ratioOf(double v) {
      return all > 0 ? v / all : 0;
    }
  }
  /*
   * Complete the plusMinus function below.
   */
  static double[] plusMinus(int[] arr) {
        /*
         * Write your code here.
         */
    Count count = new Count();
    Arrays.stream(arr).forEach(count::value);
    return new double[] {count.positiveRatio(), count.negativeRatio(), count.zeroRatio()};
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int n = Integer.parseInt(scan.nextLine().trim());

    int[] arr = new int[n];

    String[] arrItems = scan.nextLine().split(" ");

    for (int arrItr = 0; arrItr < n; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      arr[arrItr] = arrItem;
    }

    Arrays.stream(plusMinus(arr)).forEach(System.out::println);
  }
}