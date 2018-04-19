package com.michaelszymczak.courses.hr.intro.intro;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DiagonalDifference {

  /*
   * Complete the diagonalDifference function below.
   */
  static int diagonalDifference(int[][] a) {
    return new Matrix(a).diagonalDifference();
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scan.nextLine().trim());

    int[][] a = new int[n][n];

    for (int aRowItr = 0; aRowItr < n; aRowItr++) {
      String[] aRowItems = scan.nextLine().split(" ");

      for (int aColumnItr = 0; aColumnItr < n; aColumnItr++) {
        int aItem = Integer.parseInt(aRowItems[aColumnItr].trim());
        a[aRowItr][aColumnItr] = aItem;
      }
    }

    int result = diagonalDifference(a);

    bw.write(String.valueOf(result));
    bw.newLine();

    bw.close();
  }

  private static class Matrix {

    private final int[][] a;

    public Matrix(int[][] a) {
      this.a = a;
    }

    public int diagonalDifference() {
      int result = 0;
      for (int r = 0; r < a.length; r++) {
        for (int c = 0; c < a.length; c++) {
          result += primaryDiagonalPart(r, c) + secondaryDiagonalPart(r, c);
        }
      }

      return Math.abs(result);
    }

    private int primaryDiagonalPart(int r, int c) {
      return (r == c) ? a[r][c] : 0;
    }

    private int secondaryDiagonalPart(int r, int c) {
      return (r == a.length - 1 - c) ? -a[r][c] : 0;
    }
  }
}

