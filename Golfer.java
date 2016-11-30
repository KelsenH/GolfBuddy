//Golfer.java

public class Golfer implements Serializable {
  private String firstName;
  private String lastName;
  private int pars;
  private int birdies;
  private int bestScore;
  private int parThreeAvg;
  private int parFourAvg;
  private int parFiveAvg;
  private int avgHandicap;

  Golfer () {
    firstName = "";
    lastName = "";
    //Add functions to these later to automatically load data
    pars = 0;
    birdies = 0;
    bestScore = 0;
    parThreeAvg = 0;
    parFourAvg = 0;
    parFiveAvg = 0;
    avgHandicap = 0;
  } //end constructor

  Golfer (String first, String last) {
    firstName = first;
    lastName = last;
    pars = 0;
    birdies = 0;
    bestScore = 0;
    parThreeAvg = 0;
    parFourAvg = 0;
    parFiveAvg = 0;
    avgHandicap = 0;
  } //end constructor

  void setFirstName (String firstName) {
    this.firstName = firstName;
  } //end setFirstName

  void setLastName (String lastName) {
    this.lastName = lastName;
  } //setLastName

  
} //end class
