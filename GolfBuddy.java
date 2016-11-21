//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Score head = new Score (); 
  Score scoreOne = new Score (9, null, head);
  scoreOne.setScoreDate (1,1,2001);
  //System.out.println ((head.getNextScore()).getAllScores());
  Score scoreTwo = new Score (18,scoreOne, head);
  scoreTwo.setScoreDate (2,2,2002);
  //System.out.println ((head.getNextScore()).getScoreDate());
  Score scoreThree = new Score ();
  scoreThree.setScoreDate (3,3,2003);
  scoreTwo.setNextScore (scoreThree);
  Score scoreFour = new Score (18, scoreThree, scoreTwo);
  scoreFour.setScoreDate (4,4,2004);
  scoreFour.setHoleScore (5, 8);
  System.out.println (scoreFour.getAllScores());
  
  Score current = head;
  for (int i = 0;i < 5; i ++) {
      System.out.println ((current).getScoreDate());
      current = current.getNextScore();
    }  
  }
} 
