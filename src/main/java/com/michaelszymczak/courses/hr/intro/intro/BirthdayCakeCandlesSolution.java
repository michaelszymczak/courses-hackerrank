package com.michaelszymczak.courses.hr.intro.intro;

/**
 * Created 27/04/18.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;

public class BirthdayCakeCandlesSolution {

  /*
   * Complete the birthdayCakeCandles function below.
   */
  static int birthdayCakeCandles(int n, int[] ar) {
        return new BirthdayCakeCandles(ar).numberBlown();
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scan.nextLine().trim());

    int[] ar = new int[n];

    String[] arItems = scan.nextLine().split(" ");

    for (int arItr = 0; arItr < n; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      ar[arItr] = arItem;
    }

    int result = birthdayCakeCandles(n, ar);

    bw.write(String.valueOf(result));
    bw.newLine();

    bw.close();
  }

  static class BirthdayCakeCandles {

    private final int[] candlesHeight;

    public BirthdayCakeCandles(int[] candlesHeight) {
      this.candlesHeight = candlesHeight;
    }

    public int numberBlown() {

      Data data = new Data();

      for (int candleNo = 0; candleNo < candlesHeight.length; candleNo++) {
        data.nextCandleHeight(candlesHeight[candleNo]);
      }

      return data.result;
    }

    private static class Data {
      int maxHeight = MIN_VALUE;
      int result = 0;

      void nextCandleHeight(int height) {
        resetEverythingSoFarIfHigherCandleFound(height);
        checkIfCanBeBlown(height);
      }

      private void resetEverythingSoFarIfHigherCandleFound(int height) {
        if (maxHeight < height) {
          maxHeight = height;
          result = 0;
        }
      }

      private void checkIfCanBeBlown(int height) {
        if (maxHeight == height) {
          result++;
        }
      }
    }
  }
}