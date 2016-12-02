GolfBuddy: GolfBuddy.class Date.class Score.class Course.class Golfer.class

GolfBuddy.class: GolfBuddy.java
	javac GolfBuddy.java

Golfer.class: Golfer.java
	javac Golfer.java

Course.class: Course.java
	javac Course.java

Date.class: Date.java
	javac Date.java

Score.class: Score.java
	javac Score.java

run: 
	make
	java GolfBuddy

clean:
	rm *.class
