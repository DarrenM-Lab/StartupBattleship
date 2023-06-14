import java.util.ArrayList;

public class StartUpBust {
  GameHelper helper = new GameHelper();
  ArrayList<Startup> startups = new ArrayList<Startup>();
  int numOfGuesses = 0;

  public static void main(String[] args) {

  }

  private void setUpGame() {
    Startup startup1 = new Startup();
    startup1.setName("Loosy Goosey");

    Startup startup2 = new Startup();
    startup2.setName("Naymar");

    Startup startup3 = new Startup();
    startup3.setName("Ordinary");

    startups.add(startup1);
    startups.add(startup2);
    startups.add(startup3);

    for (Startup startup : startups ) {
      ArrayList<String> newLocation =  helper.placeStartup(3);

      startup.setLocation(newLocation);

    }
  }

  private void startPlaying() {

    while(!startups.empty()) {
      String input = helper.getUserInput("Guess the position: ");



      checkUserGuess(input);
    }
    finishGame();
  }

  private void checkUserGuess(String guess) {

    numOfGuesses++;

    String result = "miss!";

    for (Startups startup : startups) {
      String result = startup.checkYourself(guess);

      if ( result.equals("hit!")) {
        break;
      }

      if (result.equals("kill!")) {
        startups.remove(startup);
        break;
      }

    }

    System.out.println(result);

  }

  private void finishGame() {

    System.out.println("Gameover!");
    if (numOfGuesses < 15) {
      System.out.println("Great Job!")
    } else {
      System.out.println("You suck!")
    }


  }

  public static void main(String[] args) {
    StartUpBust game = new StartUpBust();
    game.setGame();
    game.startPlaying();
  }
}

class Startup {
  private String name;

  ArrayList<String> locationCells

  private setName(String n) {
    name = n;
  }

  private void setLocationCells(ArrayList<String> loc)

  locationCells = loc;
}

private String checkForYourself(String guess) {
  int index = locationCells.indexOf(guess);

  String result = "miss!"

  if (index >= 0) {
    locationCells.remove(index)

    if (locationCells.empty()) {
      result = "kill!";
    } else {
      result = "hit!";
    }
  }

  return result;
}
