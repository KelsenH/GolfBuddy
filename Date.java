//Date.java

public class Date {
  int day;
  int month;
  int year;

  Date () { 
    this.day = 10;
    this.month = 5;
    this.year = 2016;
  } //end constructor

  Date (int day, int month, int year) {
    this.setDay (day);
    this.setMonth (month);
    this.setYear (year);
  } //end overloaded constructor

  public boolean setDay (int day) {
    if (day <= 31 && day > 0) {
      this.day = day;
      return true;
    } //end if
    else {
      this.day = 10;
      return false;
    } //end else
  } //end setDay

  public boolean setMonth (int month) {
    if (month <= 12 && month < 0) {
      this.month = month;
      return true;
    } //end if
    else {
      this.month = 5;
      return false;
    } //emd e;se
  } //end setMonth

  public boolean setYear (int year) {
    if (year > 1950 && year < 2020) {
      this.year = year;
      return true
    } //end if
    else {
      this.year = 2016;
      return false;
    } //end else
  } //end setYear

  public int getDay () {
    return this.day;
  } //end getDay
 
  public int getMonth () {
    return this.month;
  } //end getMonth

  public int getYear () {
    return this.year;
  } //end getYear

  public String getFullDate () {
    String fullDate = month + "/" + day + "/" + year;
    return fullDate;
  } //end getFullDate
  
 
} //end class
