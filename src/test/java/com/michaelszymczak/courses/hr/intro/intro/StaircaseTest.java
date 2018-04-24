package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.junit.Assert.*;

/**
 * Created 24/04/18.
 */
public class StaircaseTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldAcceptNonNegativeNumbersOnly() throws Exception {
    staircase(-1);
  }

  @Test
  public void shouldBeEmptyIfNoHeight() throws Exception {
    assertEquals("", staircase(0));
  }

  @Test
  public void shouldHaveAppropriateHeight() throws Exception {
    rangeClosed(1, 100)
            .forEach(height ->
                    assertEquals(height, heightOf(staircase(height))));
  }

  @Test
  public void shouldHaveSteps() throws Exception {
    // given
    final String staircase = staircase(5);

    // expect
    assertEquals("#", brickAt(staircase, 1));
    assertEquals("##", brickAt(staircase, 2));
    assertEquals("###", brickAt(staircase, 3));
  }

  private int heightOf(String staircase) {
    return countMatches(staircase, '\n') + 1;
  }

  private String staircase(int n) {
    return new StaircaseSolution.Staircase(n).toString();
  }

  private String brickAt(String staircase, int stepNo) {
    return staircase.split("\\r?\\n")[stepNo - 1].trim();
  }
}