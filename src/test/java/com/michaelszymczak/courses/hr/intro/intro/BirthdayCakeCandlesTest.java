package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 27/04/18.
 */
public class BirthdayCakeCandlesTest {

  @Test
  public void shouldNotBlowAnythingIfNoCandles() throws Exception {
    assertEquals(0, numberOfBlown(new int[]{}));
  }

  @Test
  public void shouldBlowAllIfOfEqualHeight() throws Exception {
    assertEquals(5, numberOfBlown(new int[]{9,9,9,9,9}));
  }

  @Test
  public void shouldNotBlowHighestCandlesOnly() throws Exception {
    assertEquals(3, numberOfBlown(new int[]{19,19,9,18,19}));
    assertEquals(2, numberOfBlown(new int[]{19,19,20,21,21,19}));
  }

  private int numberOfBlown(int[] candlesHeight) {
    return new BirthdayCakeCandlesSolution.BirthdayCakeCandles(candlesHeight).numberBlown();
  }
}