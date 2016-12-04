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
  private float avgHandicap;
  private Vector <Course> courses = new Vector <Course> ();

  Golfer () {
    firstName = "";
    lastName = "";
    //Add functions to these later to automatically load data;
    pars = getPars ();
    birdies = getBirdies ();
    bestScoreNine = getBestScore (9);
    bestScoreEighteen = getBestScore (18);
    avgScoreNine = getAvgScore (9);
    avgScoreEighteen = getAvgScore (18);
    parThreeAvg = getAvgOnPar (3);
    parFourAvg = getAvgOnPar (4);
    parFiveAvg = getAvgOnPar (5);
    avgHandicap = getAvgHandicap ();
  } //end constructor

  Golfer (String first, String last) {
    firstName = first;
    lastName = last;
    pars = getPars ();
    birdies = getBirdies ();
    bestScoreNine = getBestScore (9);
    bestScoreEighteen = getBestScore (18);
    avgScoreNine = getAvgScore (9);
    avgScoreEighteen = getAvgScore (18);
    parThreeAvg = getAvgOnPar (3);
    parFourAvg = getAvgOnPar (4);
    parFiveAvg = getAvgOnPar (5);
    avgHandicap = getAvgHandicap ();
  } //end constructor

  public void setFirstName (String firstName) {
    this.firstName = firstName;
  } //end setFirstName

  public void setLastName (String lastName) {
    this.lastName = lastName;
  } //setLastName

  public int getPars () {
    int pars = 0;
    if (courses.isEmpty ()) {
      return 5;
    } //end if
    for (int i = 0; i < courses.size(); i ++) {
      Course currentCourse = (Course)courses.get(i);
      int coursePars = currentCourse.getGolferPars ();
      pars += coursePars;
    } //end for
  this.pars = pars;
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
    this.birdies = birdies;
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

  public int getAvgOnPar (int par) {
    if (courses.isEmpty()) {
      return 0;
    } //end if
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
          int amtTimesHolePlayed = currentCourse.timesPlayed (j);
          holeAmount += amtTimesHolePlayed;
        } //end if
      } //end for
    } //end for
    //Divide avgPar by holeAmount
    avgScore = avgScore/holeAmount;
    return avgScore;
  } //end getAvgOnPar

  public float getAvgHandicap () {
    if (courses.isEmpty()) {
      return 0;
    } //end if
    int avgSlopeRating = 120;
    int avgCourseRating = 71;
    int avgScore = getAvgScore (18);
    float handicap = ((avgScore - avgCourseRating) * 113) / avgSlopeRating;
    return handicap;
  } //end getAvgHandicap

  public void createNewCourse (String courseName) {
    Course newCourse = new Course (courseName);
    courses.add (newCourse);
  } //end createNewCourse

  public Course findCourse (String courseName) {
    for (int i = 0; i < courses.size(); i++) {
      Course currentCourse = (Course)courses.get (i);
      String currentCourseName = currentCourse.getCourseName ();
      if (courseName == currentCourseName) {
        return currentCourse;
      } //end if
    } //end for
    return null;
  } //end findCourse

  //EVERYTHING BELOW THIS LINE ARE GARBAGE TEST FUNCTIONS

  public int getCoursesVectorSize () {
    return courses.size ();
  }

  public void printGolferShit () {
    System.out.println (firstName + " " + lastName);
    System.out.println ("Pars: " + pars);
    System.out.println ("Birdies: " + birdies);
    System.out.println ("9 Hole Best: " + bestScoreNine);
    System.out.println ("18 Hole Best: " + bestScoreEighteen);
    System.out.println ("Avg Score 9: " + avgScoreNine);
    System.out.println ("Avg Score 18: " + avgScoreEighteen);
    System.out.println ("Par 3 Avg: " + parThreeAvg);
    System.out.println ("Par 4 Avg: " + parFourAvg);
    System.out.println ("Par 5 Avg: " + parFiveAvg);
    System.out.println ("Handicap Avg: " + avgHandicap);     
  } //printGolferShit

} //end class
