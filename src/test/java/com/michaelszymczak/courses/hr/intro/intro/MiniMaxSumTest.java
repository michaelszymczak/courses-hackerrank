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

  @Test
  public void shouldMiniEqualMaxIfIdenticalNumbers() throws Exception {
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {2, 2, 2, 2, 2}).mini());
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {2, 2, 2, 2, 2}).max());
    assertEquals(-4, new MiniMaxSumSolution.MiniMaxSum(new int[] {-1, -1, -1, -1, -1}).mini());
    assertEquals(-4, new MiniMaxSumSolution.MiniMaxSum(new int[] {-1, -1, -1, -1, -1}).max());
  }

  @Test
  public void shouldOmitTheHighestNumberWhenCalculatingMini() throws Exception {
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {5, 2, 2, 2, 2}).mini());
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {2, 2, 5, 2, 2}).mini());
    assertEquals(-4, new MiniMaxSumSolution.MiniMaxSum(new int[] {-1, -1, -1, -1, 0}).mini());
  }

  @Test
  public void shouldOmitTheLowestNumberWhenCalculatingMax() throws Exception {
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {-5, 2, 2, 2, 2}).max());
    assertEquals(8, new MiniMaxSumSolution.MiniMaxSum(new int[] {2, 2, -5, 2, 2}).max());
    assertEquals(-4, new MiniMaxSumSolution.MiniMaxSum(new int[] {-1, -1, -1, -1, -2}).max());
  }
}