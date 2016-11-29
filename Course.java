//Course.java
import java.io.*;

public class Course implements Serializable {
  private String courseName;
  private int[] pars = new int[18];
  private float courseRating;
  private float slopeRating;
  private int bestScore;
  private Score headScore;
  private Score scorePlace;

  Course () {
    courseName = "";
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    scorePlace = headScore;
    bestScore = 600;
  } //end constructor

  Course (String courseName) {
    this.courseName = courseName;
    courseRating = 70;
    slopeRating = 125;
    headScore = new Score ();
    scorePlace = headScore;
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

  public int findIndex () {
    Score currentScore = headScore;
    int index = 1;
    while (currentScore.getNextScore () != null) {
      currentScore = currentScore.getNextScore ();
      index ++;
    } //end while
    return index;
  } //end findIndex

  public void addNewScore (int day, int month, int year, int holesPlayed) {
    Score newScore = new Score ();
    newScore.setPlayedHoles (holesPlayed);
    newScore.setScoreDate (day, month, year);
    newScore.setScoreIndex (findIndex());
    Score currentScore = headScore;
    while (currentScore.getNextScore () != null) {
      currentScore = currentScore.getNextScore ();
    } //end while
    currentScore.setNextScore (newScore);
  } //end addNewScore

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

} //end class
