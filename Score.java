//Score.java

public class Score {
  private Date scoreDate = new Date (1,1,2000);
  private int playedHoles = 18;
  private int[] scores;
  private Score nextScore;
  private Score previousScore;

  //Constructor
  Score () {
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for loop
    nextScore = null;
    previousScore = null;
  } //end Constructor

  Score (int playedHoles, Score next, Score previous) {
    this.setPlayedHoles (playedHoles);
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for
    this.setNextScore (next);
    this.setPreviousScore (previous);
    previousScore = null;
  } //end Constructor

  public void setScoreDate (int day, int month, int year) {
    scoreDate.setDay (day);
    scoreDate.setMonth (month);
    scoreDate.setYear (year);
  } //end setScoreDate

  //Method should only be called by the constructor to validate input
  private boolean setPlayedHoles (int playedHoles) {
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
    } //end if
    else {
      Score temp = this.getNextScore ();
      this.nextScore = next;
      next.setNextScore (temp);
      next.setPreviousScore (this);
      temp.setPreviousScore (next);
    } //end else
  } //end setNextScore

  public void setPreviousScore (Score previous) {
    if (this.getPreviousScore() == null) {
      this.setPreviousExplicitly (previous);
      previous.setNextScore (this);
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

  public String getScoreDate () {
    String date = scoreDate.getMonth () + "/" + scoreDate.getDay () + "/" + scoreDate.getYear();
    return date;
  } //end getScoreDate

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

} //end class
