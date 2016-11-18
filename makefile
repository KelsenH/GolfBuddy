GolfBuddy: GolfBuddy.class Date.class Score.class

GolfBuddy.class: GolfBuddy.java
	javac GolfBuddy.java

Date.class: Date.java
	javac Date.java

Score.class: Score.java
	javac Score.java

run: 
	make
	java GolfBuddy

clean:
	rm *.class
