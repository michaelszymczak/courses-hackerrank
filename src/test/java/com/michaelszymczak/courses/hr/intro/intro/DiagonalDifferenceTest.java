package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static com.michaelszymczak.courses.hr.intro.intro.DiagonalDifference.diagonalDifference;
import static org.junit.Assert.*;

/**
 * Created 19/04/18.
 */
public class DiagonalDifferenceTest {
  @Test
  public void testName() throws Exception {
    assertEquals(0, diagonalDifference(new int[][]{}));
    assertEquals(0, diagonalDifference(new int[][]{
            {-2}
    }));
    assertEquals(3, diagonalDifference(new int[][]{
            {1 , 0},
            {0 , 2},
    }));
    assertEquals(5, diagonalDifference(new int[][]{
            {3 , 1},
            {2 , 5},
    }));

    assertEquals(6, diagonalDifference(new int[][]{
            {1 , 4},
            {5 , 2},
    }));

  }
}