package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 24/04/18.
 */
public class MiniMaxSumTest {

  @Test
  public void shouldBeZeroIfAllZeros() throws Exception {
    assertEquals(0, new MiniMaxSumSolution.MiniMaxSum(new int[] {}).mini());
    assertEquals(0, new MiniMaxSumSolution.MiniMaxSum(new int[] {}).max());
    assertEquals(0, new MiniMaxSumSolution.MiniMaxSum(new int[] {0, 0, 0, 0, 0}).mini());
    assertEquals(0, new MiniMaxSumSolution.MiniMaxSum(new int[] {0, 0, 0, 0, 0}).max());
  }
}