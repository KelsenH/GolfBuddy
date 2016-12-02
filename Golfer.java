//Golfer.java
import java.util.*;
import java.io.*;

public class Golfer implements Serializable {
  private String firstName;
  private String lastName;
  private int pars;
  private int birdies;
  private int bestScoreNine;
  private int bestScoreEighteen;
  private int avgScoreNine;
  private int avgScoreEighteen;
  private int parThreeAvg;
  private int parFourAvg;
  private int parFiveAvg;
  private int avgHandicap;
  private Vector courses;

  Golfer () {
    firstName = "";
    lastName = "";
    //Add functions to these later to automatically load data
    courses = new Vector ();
    pars = getPars ();
    birdies = getBirdies ();
    bestScoreNine = getBestScore (9);
    bestScoreEighteen = getBestScore (18);
    avgScoreNine = getAvgScore (9);
    avgScoreEighteen = getAvgScore (18);
    parThreeAvg = 0;
    parFourAvg = 0;
    parFiveAvg = 0;
    avgHandicap = 0;
  } //end constructor

  Golfer (String first, String last) {
    firstName = first;
    lastName = last;
    courses = new Vector ();
    pars = getPars ();
    birdies = getBirdies ();
    bestScoreNine = getBestScore (9);
    bestScoreEighteen = getBestScore (18);
    avgScoreNine = getAvgScore (9);
    avgScoreEighteen = getAvgScore (18);
    parThreeAvg = 0;
    parFourAvg = 0;
    parFiveAvg = 0;
    avgHandicap = 0;
  } //end constructor

  public void setFirstName (String firstName) {
    this.firstName = firstName;
  } //end setFirstName

  public void setLastName (String lastName) {
    this.lastName = lastName;
  } //setLastName

  public int getPars () {
    int pars = 0;
    if (courses.isEmpty()) {
      return 0;
    } //end if
    for (int i = 0; i < courses.size(); i ++) {
      Course currentCourse = (Course)courses.get(i);
      int coursePars = currentCourse.getGolferPars ();
      pars += coursePars;
    } //end for
  return pars;
  } //end getPars

  public int getBirdies () {
    int birdies = 0;
    if (courses.isEmpty()) {
      return 0;
    } //end if
    for (int i = 0; i < courses.size(); i++) {
      Course currentCourse = (Course)courses.get (i);
      int courseBirdies = currentCourse.getGolferBirdies();
      birdies += courseBirdies;
    } //end for
    return birdies;
  } //end getBirdies

  public int getBestScore (int holeAmount) {
    int bestScore = 0;
    if (courses.isEmpty()) {
      return 0;
    } //end if
    for (int i = 0; i < courses.size (); i ++) {
      Course currentCourse = (Course)courses.get (i);
      int courseBest = currentCourse.getBestScore (holeAmount);
      if (bestScore == 0) {
        bestScore = courseBest;
      } //end if
      else if (courseBest < bestScore) {
        bestScore = courseBest;
      } //end else if
    } //end for
    return bestScore;
  } //end getBestScore
 
  public int getAvgScore (int holeAmount) {
    //For every course, get their average score
    int avgScore = 0;
    int numOfCourses = 0;
    if (courses.isEmpty()) {
      return 0;
    }//end if
    for (int i = 0; i < courses.size (); i ++) {
      Course currentCourse = (Course)courses.get (i);
      int courseAvg = currentCourse.getAvgScore (holeAmount);
      if (courseAvg != 0) {
        numOfCourses ++;
      } //end if
      avgScore += courseAvg;
    } //end for
    avgScore = avgScore/numOfCourses;
    return avgScore;
  } //end getAvgScore

  //FIX THIS GARBAGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  public int getAvgOnPar (int par) {
    int avgScore = 0;
    int holeAmount = 0;
    //For every course
    for (int i = 0; i < courses.size (); i ++) {
      Course currentCourse = (Course)courses.get (i);
      //Find the holes on that course that are the correct par
      for (int j = 1; j < 19; j++ ) {
        int holePar = currentCourse.getPar (j);
        if (holePar == par) {
          //Go through every score and get the score for that hole
          int courseTotalForHole = currentCourse.getTotalScoreForHole (j);
          avgScore += courseTotalForHole;
        } //end if
      } //end for
      //Check every score for the course on those holes
      //Add the scores of those holes to avgPar
      //Add the number of holes of the correct par to holeAmount
    } //end for
    //Divide avgPar by holeAmount
    return 0;
  } //end getAvgOnPar

} //end class
