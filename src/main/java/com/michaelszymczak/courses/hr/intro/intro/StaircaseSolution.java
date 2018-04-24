package com.michaelszymczak.courses.hr.intro.intro;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StaircaseSolution {

  /*
   * Complete the staircase function below.
   */
  static void staircase(int n) {
    System.out.println(new Staircase(n));
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int n = Integer.parseInt(scan.nextLine().trim());

    staircase(n);
  }

  public static class Staircase {

    private final int n;

    public Staircase(int n) {
      this.n = n;
      if (n < 0)
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
      return IntStream.rangeClosed(1, n)
              .mapToObj(value -> Stream.generate(() -> "#").limit(value).collect(Collectors.joining()))
              .collect(Collectors.joining("\n"));
    }
  }
}
