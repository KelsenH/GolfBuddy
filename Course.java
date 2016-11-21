//Course.java

public class Course {
  private String courseName;
  private int[18] pars;
  private float courseRating;
  private float slopeRating;
  private Score headScore;
  private int bestScore;

  Course () {
    courseName = "";
    courseRating = 70;;
    slopeRating = 125;
    headScore = new Score ();
    bestScore = null;
  } //end constructor

  Course () {
    
  }
} //end class
