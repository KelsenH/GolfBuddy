//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Course courseTest = new Course ();
  Course courseTestTwo = new Course ("Walnut Oaks");
  courseTest.setCourseName ("Flower Hills");
  System.out.println (courseTest.getCourseName());
  courseTest.setPar (1,3);
  System.out.println (courseTest.getPar (5)); 
  }
} 
