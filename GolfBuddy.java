//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Course courseTest = new Course ();
  courseTest.setCourseName ("Flower Hills");
  //courseTest.addNewScore (10,10,2010,18);
  //courseTest.addNewScore (10,11,2012,18);
  //courseTest.addNewScore (27,8, 2012,18);
  //courseTest.addNewScore (30,5,2016,18);
  //courseTest.addNewScore (30,11,2019,18);
  //System.out.println (courseTest.findScore(3).getScoreDate());
  courseTest.loadScores ();
  courseTest.printAllScoreDates();
  Course two = new Course ("Pearl");
  two.addNewScore (15,7,2010,18);
  two.addNewScore (16,7,2010,18);
  two.printAllScoreDates ();
  }
} 
