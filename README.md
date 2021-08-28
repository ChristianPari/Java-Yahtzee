# Yahtzee CLI Program
I decided to expand upon a school assigned challenge to create a simple 'dice rolling' game that a user could use to play any game that utilized dice if they didn't have dice of their own. There was no score detection or further Yahtzee-esk functionallity so I took it upon myself to create a fully functioning Yahtzee game with CLI interface. 

## Getting Started
### `Download`
[`Yahtezee JAR File Download`](https://github.com/ChristianPari/Java-Yahtzee/raw/main/Quick_Install/Yahtzee.jar)<br>
  - Click `Leave Page` when prompted, it will not redirect you
### `Run`
Open terminal to the directory you stored the JAR file and run `java -jar Yahtzee.jar`

## Added Features
- PvP
  - Winner declaration at the end of the 13 rounds
- Score detection
  - Ability for users to pick their scores throughout each turn
- Scores are stored in a Players Scorecard
  - Scorecards are used for:
    - score types that are available
    - player score comparision at the endgame to decide a winner

## Things I Learned
This was my first full build out of a game using the command line yet. It provided for me huge amounts of practice with OOP centered concepts and ensuring my program utlizied interfaces, abstraction, inheritance and polymorphism where needed to the best of my abilities.

## Challenges I Faced
- Finding an effective way to create a scorecard
  - Allowing for a way to update scores but also give players the ability to see what they havent "filled in" yet each turn
    - `Solution` I ended up using an Enum for the Score Types and a Map to store each Score with a Integer for value or null if it had not been used yet

## In The End
This was a really fun and enjoyable project to build out, work through the struggles of code not working, but also having the fun of actually testing it out constantly and watching myself add new features was really exciting
