//Score.java

public class Score {
  private Date scoreDate = new Date (1,1,2000);
  private int playedHoles = 18;
  private int[] scores;

  //Constructor
  Score () {
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for loop
  } //end Constructor

  Score (int playedHoles) {
    this.setPlayedHoles (playedHoles);
    scores = new int [playedHoles];
    for (int i = 0; i < playedHoles; i ++) {
      this.setHoleScore (i + 1, 3);
    } //end for
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

  public String getScoreDate () {
    String date = scoreDate.getMonth () + "/" + scoreDate.getDay () + "/" + scoreDate.getYear();
    return date;
  } //end getScoreDate

  public int getHoleScore (int holeNum) {
    return scores [holeNum - 1];
  } //end getHoleScore

  public String getAllScores () {
    String scoreList = "";
    for (int i = 0; i < playedHoles; i ++) {
      scoreList += scores [i];
    } //end for loop
    return scoreList;
  } //end getAllScores

} //end class
