//GolfBuddy.java
import java.io.*;

public class GolfBuddy {
  public static void main (String []args) {
  Golfer test = new Golfer ("Kelsen", "Hazelwood");
  test.createNewCourse ("Shady Hills");
  test.createNewCourse ("High On The Hill");
  test.createNewCourse ("Canal Square");
  Course canalSquare = test.findCourse ("Canal Square");
  canalSquare.setPar (1,4);
  canalSquare.setPar (2,4);
  canalSquare.setPar (3,5);
  canalSquare.setPar (4,3);
  canalSquare.setPar (5,4);
  canalSquare.setPar (6,3);
  canalSquare.setPar (7,5);
  canalSquare.setPar (8,4);
  canalSquare.setPar (9,4);
  canalSquare.setPar (10,4);
  canalSquare.setPar (11,5);
  canalSquare.setPar (12,3);
  canalSquare.setPar (13,4);
  canalSquare.setPar (14,4);
  canalSquare.setPar (15,5);
  canalSquare.setPar (16,4);
  canalSquare.setPar (17,4);
  canalSquare.setPar (18,3);
  
  canalSquare.addNewScore (5,5,2015,18);
  canalSquare.addNewScore (6,17,2014,18);
  test.getPars ();
  test.getBirdies ();
  test.printGolferShit ();

  System.out.println (test.getCoursesVectorSize());
  }
} 
