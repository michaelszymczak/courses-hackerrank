package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 24/04/18.
 */
public class StaircaseTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldAcceptNonNegativeNumbersOnly() throws Exception {
    new StaircaseSolution.Staircase(-1);
  }

  @Test
  public void shouldBeEmptyIfNoHeight() throws Exception {
    assertEquals("", new StaircaseSolution.Staircase(0).toString());
  }

  
}