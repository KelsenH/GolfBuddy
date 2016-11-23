//Course.java

public class Course implements Serializable {
  private String courseName;
  private int[18] pars;
  private float courseRating;
  private float slopeRating;
  private Score headScore;
  private int bestScore;

  Course () {
    courseName = "";
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    bestScore = null;
  } //end constructor

  Course (String courseName) {
    this.courseName = courseName;
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    bestScore = null;
  } //end constructor

  public void setCourseName (String courseName) {
    this.courseName = courseName;
  } //end setCourseName

  public void setPar (int holeNum, int par) {
    pars[holeNum - 1] = par;
  } //end setPar

  public String getCourseName () {
    return courseName;
  } //end getCourseName

  public int getPar (int holeNum) {
    return pars[holeNum - 1];
  } //end getPar 

  public int getBestScore () {
    
  }
} //end class
