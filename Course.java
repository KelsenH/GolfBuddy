//Course.java
import java.io.*;

public class Course implements Serializable {
  private String courseName;
  private int[] pars = new int[18];
  private float courseRating;
  private float slopeRating;
  private int bestScore;
  public Score headScore;

  Course () {
    courseName = "";
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    bestScore = 600;
  } //end constructor

  Course (String courseName) {
    this.courseName = courseName;
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    bestScore = 600;
  } //end constructor

  public void setCourseName (String courseName) {
    this.courseName = courseName;
  } //end setCourseName

  public void setPar (int holeNum, int par) {
    pars[holeNum - 1] = par;
  } //end setPar

  public void setCourseRating (float courseRating) {
    this.courseRating = courseRating;
  } //end setCourseRating

  public void setSlopeRating (float slopeRating) {
    this.slopeRating = slopeRating;
  } //end setSlopeRating

  public String getCourseName () {
    return courseName;
  } //end getCourseName

  public int getPar (int holeNum) {
    return pars[holeNum - 1];
  } //end getPar 

  public float getCourseRating () {
    return courseRating;
  } //end getCourseRating

  public float getSlopeRating () {
    return slopeRating;
  } //end getSlopeRating

  public void addNewScore (int day, int month, int year, int holesPlayed) {
    Score newScore = new Score ();
    newScore.setPlayedHoles (holesPlayed);
    newScore.setScoreDate (day, month, year);
    Score currentScore = headScore.getNextScore ();
    if (currentScore == null) {
      currentScore = headScore;
    } //end if
    boolean keepGoing = true;
    while (keepGoing) {
      if (currentScore.isNewer(newScore)) {
        Score safeSpot = currentScore;
        currentScore = currentScore.getNextScore ();
        if (currentScore == null) {
          currentScore = safeSpot;
          currentScore.setNextScore (newScore);
          keepGoing = false;
        } //end if    
      } //end if
      else {
        currentScore.setPreviousScore (newScore);
        keepGoing = false;
      } //end else
    } //end while
    setIndexes ();
  } //end addNewScore

  public void setIndexes () {
    Score currentScore = headScore.getNextScore ();
    int currentIndex = 1;
    while (currentScore != null) {
      currentScore.setScoreIndex (currentIndex);
      currentIndex ++;
      currentScore = currentScore.getNextScore ();
    } //end while
  } //end setIndexes

  public int getBestScore (int holesPlayed) {
    Score current = headScore.getNextScore ();
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

  public Score findScore (int index) {
    Score currentScore = headScore;
    while (currentScore.getScoreIndex () != index) {
      currentScore = currentScore.getNextScore ();
      if (currentScore == null) {
        return headScore;
      } //end if
    } //end while
    return currentScore;
  } //end findScore

  public void setHoleScore (int index, int holeNumber, int holeScore) { 
    Score score = findScore (index);
    score.setHoleScore (holeNumber, holeScore);
  } //end setHoleScore

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

  public void printAllScoreDates () {
    boolean keepGoing = true;
    int amount = 0;
    Score current = headScore;
    while (keepGoing) {
      if (current == null) {
        keepGoing = false;
      }
      else {
        System.out.println (current.getScoreDate ());
        System.out.println (amount);
        current = current.getNextScore ();
        amount ++;
      }
    }
  } 

} //end class
