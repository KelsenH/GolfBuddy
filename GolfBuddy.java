//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Course courseTest = new Course ();
  courseTest.setCourseName ("Flower Hills");
  courseTest.addNewScore (10,10,2010,18);
  courseTest.addNewScore (9,9,2009,18);
  Score test = courseTest.findScore (2);
  System.out.println (courseTest.findScore (2).getScoreDate());
  System.out.println (test.getTotalScore ());
  System.out.println (courseTest.getBestScore (18));
  courseTest.saveScores ();
  courseTest.loadScores ();
  courseTest.setHoleScore (2,5,1);
  System.out.println (courseTest.getBestScore (18));
  }
} 
