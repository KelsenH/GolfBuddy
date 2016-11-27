//Course.java

public class Course implements Serializable {
  private String courseName;
  private int[18] pars;
  private float courseRating;
  private float slopeRating;
  private Score headScore;

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

  public int getBestScore (int holesPlayed) {
    Score current = headScore;
    int bestScore = 400;
    if (holesPlayed != 9 && holesPlayed != 18) {
      holesPlayed = 18;
    } //end if
    while (current != null) {
      if (current.getPlayedHoles () == holesPlayed) {
        int currentScore = current.getTotalScore ();
        if (currentScore < bestScore) {
          bestScore = currentScore;
        } //end if
        else {} //end else
      } //end if
      current = current.getNextScore ();
    } //end while 
    return bestScore;
  } //end getBestScore

  public void saveScores () {
    try {
      String fileName = this.courseName + "Scores.dat";
      FileOutputStream fileOut = new FileOutputStream (fileName);
      ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
      objectOut.writeObject (headScore);
    } catch (Exception e) {
      System.out.println (e.getMessage ());
    } //end try
  } //end saveCourse

  public void loadScores () {
    try {
      String fileName = this.courseName + "Scores.dat";
      FileInputStream fileInput = new FileInputStream (fileName);
      ObjectInputStream objectIn = new ObjectInputStream (fileInput);
      headScore = (Score)objectIn.readObject();
    } catch (Exception e) {
      System.out.println (e.getMessage ());
    } // end try
  } //end loadScores

} //end class
