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
    if (bestScore == 400) {
      bestScore = 0;
    } //end if
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
 
  public int getGolferPars () {
    //Needs to count total pars a golfer has gotten on a course
    int pars = 0;
    //For each hole on the course
    for (int i = 1; i < 19; i++) {
      int holePar = getPar (i);
      //Check all scores for that hole
      Score currentScore = headScore.getNextScore ();
      while (currentScore != null) {
        int golferScore = currentScore.getHoleScore (i);
        if (holePar == golferScore) {
          pars ++;
        } //end if
        currentScore = currentScore.getNextScore ();
      } //end while
    } //end for
    return pars;
  } //end getGolferPars

  public int getGolferBirdies () {
    int birdies = 0;
    //For each hole on the course
    for (int i = 1; i < 19; i++) {
      int holePar = getPar (i);
      //Check all scores for that hole
      Score currentScore = headScore.getNextScore ();
      while (currentScore != null) {
        int golferScore = currentScore.getHoleScore (i);
        if (holePar-1 == golferScore) {
          birdies ++;
        } //end if
        currentScore = currentScore.getNextScore ();
      } //end while
    } //end for
    return birdies;
  } //end getGolferBirdies

  public int getAvgScore (int holesPlayed) {
    int avgScore = 0;
    int numOfScores = 0;
    //For every score
    Score currentScore = headScore.getNextScore ();
    if (currentScore == null) {
      return 0;
    } //end if
    while (currentScore != null) {
      int currentHolesPlayed = currentScore.getPlayedHoles ();
      if (holesPlayed == currentHolesPlayed) {
        //Add the total score to the avgScore
        avgScore += currentScore.getTotalScore ();
        //Add one to numOfScores
        numOfScores ++;
        currentScore = currentScore.getNextScore ();
      } //end if
      else {
        currentScore = currentScore.getNextScore ();
      } //end else
    } //end while
    //Divide avgScore by numberOfScores
    if (numOfScores == 0) {
      return 0;
    } //end if
    avgScore = avgScore/numOfScores;
    return avgScore;
  } //end getAvgScore

  public int getTotalScoreForHole (int holeNumber) {
    //For every score
    int totalScore = 0;
    Score currentScore = headScore.getNextScore ();
    while (currentScore != null) {
      if (holeNumber > 9 && (currentScore.getPlayedHoles ()) > 9 ) {
        //Add together the scores at the holeNumber
        int scoreAtHoleNum = currentScore.getHoleScore (holeNumber);
        totalScore += scoreAtHoleNum;
      } //end if
      else {
        int scoreAtHoleNum = currentScore.getHoleScore (holeNumber);
        totalScore += scoreAtHoleNum;
      } //end else
      currentScore = currentScore.getNextScore ();
    } //end while
    return totalScore;
  } //end getScoreForHole

  public int timesPlayed (int holeNum) {
    int timesPlayed = 0;
    Score currentScore = headScore.getNextScore ();
    if (currentScore == null) {
      return 1;
    } //end if
    while (currentScore != null) {
      if (holeNum > 9) {
        if (currentScore.getPlayedHoles () > 9) {
          timesPlayed ++;
        } //end if
      } //end if
      else if (holeNum <= 9) {
        timesPlayed ++;
      } //end else if
      else {
        System.out.println ("Something went wrong");
      } //end else
    currentScore = currentScore.getNextScore ();
    } //end while
    return timesPlayed;
  } //end timesPlayed

} //end class
