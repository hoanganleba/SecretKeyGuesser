package Project.Ori;

public class SecretKeyGuesser {

  // Day2: LinkedList, ArrayList, Binary Search Tree ==> Day 3: Create Interfaces for these

    /**
     * Add 5 characters into an arraylist:
     * Time Complexity: O(n) because in real game, number of valid character will be different
     */
//    private static final List<Character> VALID_CHARACTERS = Arrays.asList('M', 'O', 'C', 'H', 'A');
    private static final MyArrayList<Character> VALID_CHARACTERS = new MyArrayList<>(); // Space Complexity: O(1)
  public void start() {
      VALID_CHARACTERS.add('M');
      VALID_CHARACTERS.add('O');
      VALID_CHARACTERS.add('C');
      VALID_CHARACTERS.add('H');
      VALID_CHARACTERS.add('A');
    SecretKey secretKey = new SecretKey(); // Time Complexity: O(1) Space Complexity: O(1)

    StringBuilder initialKey = new StringBuilder(); // Time Complexity: O(1) Space Complexity: O(1)
    initialKey.append("M".repeat(12)); // Time Complexity: O(1) Space Complexity: O(1)

    int matches = secretKey.guess(initialKey.toString()); // Time Complexity: O(n) Space Complexity: O(1)

    if (matches < 12) {
      for (int guessedIndex = 11; guessedIndex >= 0 && matches != 12; guessedIndex--) { // Time Complexity: O(1) Space Complexity: O(1)
          for (int charListIndex=0; charListIndex < VALID_CHARACTERS.size(); charListIndex++) {// j : 0 --> 5 // Time Complexity: O(1) Space Complexity: O(1)
              String modifiedKey = createModifiedKey(initialKey.toString(), guessedIndex, VALID_CHARACTERS.get(charListIndex)); // Time Complexity: O(1) Space Complexity: O(1)
              System.out.println("Guessing... " + modifiedKey); // Time Complexity: O(1)
              int newMatches = secretKey.guess(modifiedKey); // Time Complexity: O(n)
              if (newMatches < matches ) { // Time Complexity: O(1)
                break; // Time Complexity: O(1)
              }
              if (newMatches > matches) { // Time Complexity: O(1)
                  initialKey = new StringBuilder(modifiedKey); // Time Complexity: O(1)
                  matches = newMatches; // Time Complexity: O(1)
                  break; // Time Complexity: O(1)
              }
          }
      }
    }
  }

  private String createModifiedKey(String originalKey, int index, char newCharacter) {
    StringBuilder modifiedKeyBuilder = new StringBuilder(originalKey); // Time Complexity: O(1)
    modifiedKeyBuilder.setCharAt(index, newCharacter); // Time Complexity: O(1)
    return modifiedKeyBuilder.toString();
  }
}

