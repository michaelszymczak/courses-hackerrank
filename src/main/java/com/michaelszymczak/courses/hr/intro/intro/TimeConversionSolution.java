package com.michaelszymczak.courses.hr.intro.intro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class TimeConversionSolution {

  /*
   * Complete the timeConversion function below.
   */
  static String timeConversion(String s) {
    return new TwelveHoursTime(s).asTwentyFour();
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scan.nextLine();

    String result = timeConversion(s);

    bw.write(result);
    bw.newLine();

    bw.close();
  }

  enum AMPM {
    AM,
    PM
  }

  static class TwelveHoursTime {

    private final String value;

    public TwelveHoursTime(String s) {
      this.value = valid(s);
    }

    public String asTwentyFour() {
      final Matcher matcher = pattern.matcher(value);
      matcher.find();
      return format("%02d:%s",
              adjustedHours(
                      parseInt(matcher.group(1)),
                      matcher.group(3).equals("AM")
              ), matcher.group(2));
    }

    private int adjustedHours(int hours, boolean isAM) {
      return (hours + ((hours == 12) ?
              isAM ? 12 : 0 :
              isAM ? 0 : 12)
      ) % 24;
    }

    private static final Pattern pattern = Pattern.compile("^([0-1][0-9]):([0-9][0-9]:[0-9][0-9])(AM|PM)$");

    private String valid(String s) {
      final Matcher matcher = pattern.matcher(s);
      if (matcher.matches()) {
        return s;
      } else {
        throw new IllegalArgumentException();
      }
    }
  }
}
