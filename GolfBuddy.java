//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Score score = new Score ();
  Score scoreTwo = new Score ();
  score.setNextScore (scoreTwo);
  scoreTwo.setPreviousScore (score);
  scoreTwo.setScoreDate (10,8,2008);
  System.out.println ((score.getNextScore()).getScoreDate ());
  Score scoreThree = new Score (18, null, scoreTwo); 
  }
}
