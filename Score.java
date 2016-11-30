//Score.java
import java.io.*;

public class Score implements Serializable {
  private Date scoreDate = new Date (1,1,2019);
  private int playedHoles = 18;
  private int[] scores;
  private Score nextScore;
  private Score previousScore;
  private int index;

  //Constructor
  Score () {
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for loop
    nextScore = null;
    previousScore = null;
    index = 0;
  } //end Constructor

  Score (int playedHoles, Score next, Score previous) {
    this.setPlayedHoles (playedHoles);
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for
    this.setNextScore (next);
    this.setPreviousScore (previous);
    index = 0;
  } //end Constructor

  public void setScoreDate (int day, int month, int year) {
    scoreDate.setDay (day);
    scoreDate.setMonth (month);
    scoreDate.setYear (year);
  } //end setScoreDate

  //Method should only be called by the constructor to validate input
  public boolean setPlayedHoles (int playedHoles) {
    if (playedHoles == 18 | playedHoles == 9 ) {
      this.playedHoles = playedHoles;
      return true;
    } //end if
    else {
      this.playedHoles = 18;
      return false;
    } //end else
  } //end setPlayedHoles

  public void setHoleScore (int holeNum, int holeScore) {
    scores [holeNum - 1] = holeScore;
  } //end setHoleScore

  public void setNextScore (Score next) {
    if (this.nextScore == null) {
      this.nextScore = next;
      next.previousScore = this;
    } //end if
    else {
      Score temp = this.getNextScore ();
      this.nextScore = next;
      next.nextScore = temp;
      next.previousScore = this;
      temp.previousScore = next;
    } //end else
  } //end setNextScore

  public void setPreviousScore (Score previous) {
    if (this.getPreviousScore() == null) {
      this.previousScore = previous;
      previous.nextScore = this;
    }  //end if
    else {
      Score temp = this.getPreviousScore ();
      this.previousScore = previous;
      previous.setPreviousExplicitly (temp);
      temp.setNextExplicitly (previous);
      previous.setNextExplicitly (this);
    } //end else
  } //end setPreviousScore
  
  public void setPreviousExplicitly (Score prev) {
    this.previousScore = prev;
  } //end setPreviousExplicitly

  public void setNextExplicitly (Score next) {
    this.nextScore = next;
  } //end setNextExplicitly

  public void setScoreIndex (int index) {
    this.index = index;
  } //end setScoreIndex

  public String getScoreDate () {
    String date = scoreDate.getMonth () + "/" + scoreDate.getDay () + "/" + scoreDate.getYear();
    return date;
  } //end getScoreDate
  
  public int getPlayedHoles () {
    return playedHoles;
  } //end getPlayedHoles
  
  public int getHoleScore (int holeNum) {
    return scores [holeNum - 1];
  } //end getHoleScore

  public Score getNextScore () {
    return this.nextScore;
  }//end getNextScore

  public Score getPreviousScore () {
    return this.previousScore;
  }//end getPreviousScore

  public String getAllScores () {
    String scoreList = "";
    for (int i = 0; i < playedHoles; i ++) {
      scoreList += scores [i];
    } //end for loop
    return scoreList;
  } //end getAllScores

  public int getTotalScore () {
    int totalScore = 0;
    for (int i = 0; i < scores.length; i ++) {
      totalScore += scores[i];
    } // end for
    return totalScore;
  } //end getTotalScore
 
  public int getScoreIndex () {
    return index;
  } //end getScoreIndex

  public boolean isNewer (Score otherScore) {
    int year = this.scoreDate.getYear ();
    int month = this.scoreDate.getMonth ();
    int day = this.scoreDate.getDay ();
    int otherScoreYear = otherScore.scoreDate.getYear ();
    int otherScoreMonth = otherScore.scoreDate.getMonth ();
    int otherScoreDay = otherScore.scoreDate.getDay ();

    if (year > otherScoreYear) {
       return true;
    } //end if
    else if (year < otherScoreYear) {
      return false;
    } //end else if
    else if (year == otherScoreYear) {
      if (month > otherScoreMonth) {
        return true;
      } //end if
      else if (month < otherScoreMonth) {
        return false;
      } //end else if
      else {
        if (day > otherScoreDay) {
          return true;
        } //end if
        else if (day < otherScoreDay) {
          return false;
        } //end else if
        else {
          return true;
        } //end else
      } //end else
    } //end else
    else {
      return false;
    } //end else
  } //end isNewer


} //end class
