package com.michaelszymczak.courses.codility.lessons.lesson001;

import org.junit.Test;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

/**
 * Created 24/06/18.
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  public void returnZeroIfNoGaps() throws Exception {
    assertEquals(0, solution.solution(0));
  }

  @Test
  public void shouldDetectOneGap() throws Exception {
    assertEquals(1, solution.solution(intOf("101")));
    assertEquals(3, solution.solution(intOf("10001")));
    assertEquals(2, solution.solution(intOf("1111001111")));
  }

  @Test
  public void shouldNotTreatTrailingZerosAsAGap() throws Exception {
    assertEquals(0, solution.solution(intOf("001")));
    assertEquals(0, solution.solution(intOf("100")));
    assertEquals(0, solution.solution(intOf("00100")));
    assertEquals(1, solution.solution(intOf("101000")));
    assertEquals(1, solution.solution(intOf("000101000")));
  }

  @Test
  public void shouldFindTheLongestGapEvenIfOccurLater() throws Exception {
    assertEquals(7, solution.solution(intOf("1001111000000011110001")));
  }

  private int intOf(String binaryString) {
    return parseInt(binaryString, 2);
  }
}