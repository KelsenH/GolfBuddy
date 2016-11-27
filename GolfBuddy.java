//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Score head = new Score (); 
  Score scoreOne = new Score (18, null, head);
  System.out.println (scoreOne.getTotalScore ()); 
  }
} 
