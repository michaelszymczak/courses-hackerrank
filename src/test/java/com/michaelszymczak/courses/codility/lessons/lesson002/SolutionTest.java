package com.michaelszymczak.courses.codility.lessons.lesson002;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 24/06/18.
 */
public class SolutionTest {

  private Solution solution = new Solution();

  @Test
  public void shouldReturnTheSameArrayIfNoRotation() throws Exception {
    assertArrayEquals(new int[]{1,2,3}, solution.solution(new int[]{1,2,3}, 0));
  }

  @Test
  public void shouldPlaceElementInTheBeginningIfRotated() throws Exception {
    assertArrayEquals(new int[]{3,1,2}, solution.solution(new int[]{1,2,3}, 1));
    assertArrayEquals(new int[]{2,3,1}, solution.solution(new int[]{1,2,3}, 2));
  }

  @Test
  public void shouldPlReturnIdenticalArrayIfRotatedAll() throws Exception {
    assertArrayEquals(new int[]{1,2,3}, solution.solution(new int[]{1,2,3}, 3));
    assertArrayEquals(new int[]{1,2,3}, solution.solution(new int[]{1,2,3}, 6));
  }

  @Test
  public void shouldAllowRotationsLargerThanSizeOfTheArray() throws Exception {
    assertArrayEquals(solution.solution(new int[]{1,2,3}, 1), solution.solution(new int[]{1,2,3}, 4));
    assertArrayEquals(solution.solution(new int[]{1,2,3}, 1), solution.solution(new int[]{1,2,3}, 7));
  }

  @Test
  public void shouldHandleEmptyArray() throws Exception {
    assertArrayEquals(new int[]{}, solution.solution(new int[]{}, 0));
    assertArrayEquals(new int[]{}, solution.solution(new int[]{}, 5));
  }
}