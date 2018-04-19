package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import java.util.Arrays;

import static com.michaelszymczak.courses.hr.intro.intro.PlusMinus.plusMinus;
import static org.junit.Assert.*;

/**
 * Created 19/04/18.
 */
public class PlusMinusTest {
  @Test
  public void testName() throws Exception {
    final double delta = 1e-8;
    assertArrayEquals(new double[] {1,0,0}, plusMinus(new int[] {1}), delta);
    assertEquals(2.0/6.0, plusMinus(new int[] {1,0,-4,2,-1,0})[0], delta);
    assertEquals(2.0/7.0, plusMinus(new int[] {1,0,-4,2,-1,0,0})[1], delta);
    assertEquals(3.0/7.0, plusMinus(new int[] {1,0,-4,2,-1,0,0})[2], delta);
  }
}