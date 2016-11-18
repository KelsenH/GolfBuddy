//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Score score = new Score (9);
  score.setHoleScore (7, 5);
  System.out.println (score.getHoleScore (7));
  score.setScoreDate (10, 5, 2016);
  System.out.println (score.getScoreDate()); 
  }
}
