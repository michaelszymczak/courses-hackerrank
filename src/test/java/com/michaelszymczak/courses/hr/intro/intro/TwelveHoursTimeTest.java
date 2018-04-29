package com.michaelszymczak.courses.hr.intro.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 29/04/18.
 */
public class TwelveHoursTimeTest {

  @Test
  public void shouldBeSameTimeBetween1amAndNoon() throws Exception {
    assertEquals("01:00:00", as24("01:00:00AM"));
    assertEquals("07:05:45", as24("07:05:45AM"));
    assertEquals("11:59:59", as24("11:59:59AM"));
    assertEquals("12:00:00", as24("12:00:00PM"));
    assertEquals("12:59:59", as24("12:59:59PM"));
  }

  @Test
  public void shouldBeIn24FormatBetween1pmAndBeforeMidnight() throws Exception {
    assertEquals("13:00:00", as24("01:00:00PM"));
    assertEquals("23:59:59", as24("11:59:59PM"));
  }

  @Test
  public void shouldHandleMidnight() throws Exception {
    assertEquals("00:00:00", as24("12:00:00AM"));
    assertEquals("00:59:59", as24("12:59:59AM"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldRejectAmbiguousInput() throws Exception {
    as24("07:05:45");
  }

  private String as24(String _12_time) {
    return new TimeConversionSolution.TwelveHoursTime(_12_time).asTwentyFour();
  }
}