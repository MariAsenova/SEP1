import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * A class containing a constructor for date and time and also the methods for using this data
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 * Also the date it's going to be stored in a binary document so the class is Serialized
 */

public class DateTime implements Serializable
{
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minute;

  /**
   * Five-argument constructor which initialize a date and time
   *
   * @param day    the day to add to the date
   * @param month  the month to add to the date
   * @param year   the year to add to the date
   * @param hour   the hour to add to the time of the date
   * @param minute the minute to add to the time of the date
   */
  public DateTime(int day, int month, int year, int hour, int minute)
  {
    boolean isLeapYear = false;
    if (year % 4 == 0)
    {
      if (year % 100 == 0)
      {
        if (year % 400 == 0)
          isLeapYear = true;
        else
          isLeapYear = false;
      }
      else
        isLeapYear = true;
    }
    else
    {
      isLeapYear = false;
    }
    if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
    {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
          || month == 10 || month == 12)
      {
        if (day > 0 && day < 32)
        {
          this.day = day;
          this.hour = hour;
          this.minute = minute;
          this.month = month;
          this.year = year;

        }
        else
        {
          System.out.println(
              "The date and time has not been created. Enter correct values");
        }
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
        if (day > 0 && day < 31)
        {
          this.day = day;
          this.hour = hour;
          this.minute = minute;
          this.month = month;
          this.year = year;
        }
        else
        {
          System.out.println(
              "The date and time has not been created. Enter correct values");
        }
      }
      else if (month == 2)
      {
        if (isLeapYear)
        {
          if (day > 0 && day < 30)
          {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.month = month;
            this.year = year;
          }
          else
          {
            System.out.println(
                "The date and time has not been created. Enter correct values");
          }
        }
        else
        {
          if (day > 0 && day < 29)
          {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.month = month;
            this.year = year;
          }
          else
          {
            System.out.println(
                "The date and time has not been created. Enter correct values");
          }

        }
      }
      else
      {
        System.out.println(
            "The date and time has not been created. Enter correct values");
      }
    }
    else
    {
      System.out.println(
          "The date and time has not been created. Enter correct values");
    }
  }

  /**
   * Gets the day of the date
   *
   * @return the day of the date
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Sets the day of the Date
   *
   * @param day the day of the date that we want to set
   */
  public void setDay(int day)
  {
    this.day = day;
  }

  /**
   * Gets the month of the date
   *
   * @return the month of the date
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Sets the month of the Date
   *
   * @param month the month of the date that we want to set
   */
  public void setMonth(int month)
  {
    this.month = month;
  }

  /**
   * Gets the year of the date
   *
   * @return the year of the date
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Sets the year of the Date
   *
   * @param year the year of the date that we want to set
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * Gets the hour of the time in that date
   *
   * @return the hour of the time in that date
   */
  public int getHour()
  {
    return hour;
  }

  /**
   * Gets the hour represented as a string
   *
   * @return a string representation of the hour
   */
  public String displayHour()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(hour);
  }

  /**
   * Sets the hour of the Time in that date
   *
   * @param hour the hour of the Time in that Date
   */
  public void setHour(int hour)
  {
    this.hour = hour;
  }

  /**
   * Gets the minute of the time in that date
   *
   * @return the minute of the time in that date
   */
  public int getMinute()
  {
    return minute;
  }

  /**
   * Gets the minute represented as a string
   *
   * @return a string representation of the minute
   */
  public String displayMinute()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(minute);
  }

  /**
   * Sets the minute of the Time in that date
   *
   * @param minute the minute of the time in that Date
   */
  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  /**
   * Check if the current DateTime object is before another DateTime object
   *
   * @param date2 the DateTime object to compare against
   * @return true if the current DateTime object is before the other DateTime object, false otherwise
   */
  public boolean isBefore(DateTime date2)
  {
    int ok = 0;
    if (year < date2.year)
      ok = 1;
    if (year == date2.year)
    {
      if (month < date2.month)
      {
        ok = 1;
      }
      if (month == date2.month)
      {
        if (day < date2.day)
        {
          ok = 1;
        }
        if (day == date2.day)
        {
          if (hour < date2.hour)
          {
            ok = 1;
          }
          if (hour == date2.hour)
          {
            if (minute < date2.minute)
            {
              ok = 1;
            }
          }
        }
      }
    }
    return ok == 1;
  }

  /**
   * Checks if the current DateTime object is after another DateTime object
   *
   * @param date2 the DateTime object to compare against
   * @return true if the current DateTime object is after the other DateTime object, false otherwise
   */
  public boolean isAfter(DateTime date2)
  {
    int ok = 0;
    if (year > date2.year)
      ok = 1;
    if (year == date2.year)
    {
      if (month > date2.month)
      {
        ok = 1;
      }
      if (month == date2.month)
      {
        if (day > date2.day)
        {
          ok = 1;
        }
        if (day == date2.day)
        {
          if (hour > date2.hour)
          {
            ok = 1;
          }
          if (hour == date2.hour)
          {
            if (minute > date2.minute)
            {
              ok = 1;
            }
          }
        }
      }
    }
    return ok == 1;
  }

  /**
   * Gets a string representation of the date
   *
   * @return a string representation of the date
   */
  public String getDate()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(day) + "/" + formatter.format(month) + "/"
        + formatter.format(year);
  }

  /**
   * Gets a string representation of the time
   *
   * @return the string representation of the time
   */
  public String getTime()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(hour) + ":" + formatter.format(minute);
  }

  /**
   * Gets the last day of the month
   *
   * @param month the month for which to get the last day
   * @param year  the year of the given month
   * @return the number of days in the given month and year
   */
  public static int lastDayOfTheMonth(int month, int year)
  {
    boolean isLeapYear = false;
    if (year % 4 == 0)
    {
      if (year % 100 == 0)
      {
        if (year % 400 == 0)
        {
          isLeapYear = true;
        }
        else
        {
          isLeapYear = false;
        }
      }
      else
      {
        isLeapYear = true;
      }
    }
    else
    {
      isLeapYear = false;
    }

    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else if (month == 2)
    {
      if (isLeapYear)
      {
        return 29;
      }
      else
      {
        return 28;
      }
    }
    else
    {
      return 0;
    }
  }

  /**
   * Returns a string representation of the Date and Time
   *
   * @return a string representation of the Date and Time in the format: "day/month/year hour:minute"
   */
  public String toString()
  {
    DecimalFormat formatter = new DecimalFormat("00");
    return formatter.format(day) + "/" + formatter.format(month) + "/"
        + formatter.format(year) + " " + formatter.format(hour) + ":"
        + formatter.format(minute);
  }

  public boolean equalsDate(Object obj)
  {
    if (!(obj instanceof DateTime))
    {
      return false;
    }
    DateTime other = (DateTime) obj;
    return day == other.day && month == other.month && year == other.year;
  }

  /**
   * Compares day, month, year, hour and minute of two DateTime objects
   *
   * @param obj the object to compare with
   * @return true if the given object is equal to this DateTime object
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof DateTime))
    {
      return false;
    }
    DateTime other = (DateTime) obj;
    return day == other.day && month == other.month && year == other.year
        && hour == other.hour && minute == other.minute;
  }
}
