package com.michaelszymczak.courses.hr.intro.intro;

import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.generate;

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

  static class Staircase {

    private final int height;

    public Staircase(int height) {
      this.height = height;
      if (height < 0)
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
      return rangeClosed(1, height)
              .mapToObj(this::step)
              .collect(joining("\n"));
    }

    private String step(int stepFromTheTop) {
      return characters(" ", height - stepFromTheTop) + characters("#", stepFromTheTop);
    }

    private String characters(String character, int howMany) {
      return generate(() ->  character).limit(howMany).collect(joining());
    }
  }
}
