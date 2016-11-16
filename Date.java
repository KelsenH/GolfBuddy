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
    this.day = day;
    this.month = month;
    this.year = year;
  } //end overloaded constructor

  public void setDay (int day) {
    this.day = day;
  } //end setDay

  public void setMonth (int month) {
    this.month = month;
  } //end setMonth

  public void setYear (int year) {
    this.year = year;
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
  
  public static void main (String []args) {
    Date date = new Date (12,6,1976);
  } //end main
 
} //end class
