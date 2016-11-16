//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
    Date date = new Date (11,6,1954);
    System.out.println (date.getDay ());
    System.out.println (date.getYear ());
    System.out.println (date.getMonth ());
    date.setDay (8);
    date.setMonth (7);
    date.setYear (2066);
     System.out.println (date.getDay ());
    System.out.println (date.getYear ());
    System.out.println (date.getMonth ());
      
  }
}
