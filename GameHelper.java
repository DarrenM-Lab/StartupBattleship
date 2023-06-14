import java.util.*

class GameHelper {
  private static final String abc = "abcdefg";
  private static final int GRID_LENGTH = 7;
  private static final int GRID_SIZE = 49;
  private static final int MAXIMUM_ATTEMPTS;
  static final int HORIZONTAL_INCREMENT = 1;
  static final int VERTICAL_INCREMENT = GRID_LENGTH;
  private final int[] grid = new int[GRID_SIZE];
  private final Random random = new Random();
  private int startupCount = 0;

  public String getUserInput() {
    Scanner scanner = new Scanner(System.in)
    return scanner.nextLine();
  }

  public ArrayList<String> placeStartup(int startupParts) {
    int[] startupCoords = new int[startupParts]
    boolean success = false;
    int attempts = 0;
    startupCount++;
    int increment = getIncrement();

    while( !success & attempts++ < MAXIMUM_ATTEMPTS) {
      int location = random.nextInt(GRID_SIZE);

      for (i = 0; i < startupCoords.length; i++) {
        startupCoords[i] = location;
        location += increment;
      }

      if (locationAvailable(startupCoords, increment)) {
        success = checkIfAvailable(startupCoords);
      }
    }
    placeInPosition(startupCoords);

    ArrayList<String> alphaCells = getAlphaCells(startupCoords);

    return alphaCells;
  }

  private boolean locationAvailable(int[] startupCoords, int increment) {
    int location = startupCoords[startupCoords.length -1];
    if (increment == HORIZONTAL_INCREMENT) {
      return calcIndexFromRow(startupCoords[0]) == calcIndexFromRow(location);
    } else {
      return location < GRID_SIZE;
    }
  }

  private boolean checkIfAvailable(int[] startupCoords) {
    for (int index: startupCoords) {
      if(grid[index] != 0) {
        return false;
      }
    }
    return true;
  }

  private void placeInPosition(int[] startupCoords) {
    for (int index: startupCoords) {
      grid[index] = 1;
    }
  }

  private ArrayList<String> getAlphaCells(int[] startupCoords) {
    ArrayList<String> alphaCells = new ArrayList<String>();

    for (int index: startupCoords) {
      String cell = createAlphaCell(index);
      alphaCells.add(cell);
    }
    return alphaCells;
  }

  private String createAlphaCell(int index) {
    int row = calcIndexFromRow(index);
    int column = index % GRID_LENGTH;
    String letter = abc.substring(column, column + 1);
    return letter + row;
  }

  private int calcIndexFromRow(int index) {
    return index / GRID_LENGTH;
  }

  private int getIncrement() {
    if (startupCount % 2 == 0) {
      return HORIZONTAL_INCREMENT;
    } else {
      return VERTICAL_INCREMENT;
    }
  }
}
