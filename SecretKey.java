package Project.Ori;

public class SecretKey {
  String correctKey;
  private int counter;

  public SecretKey() {
    // for the real test, your program will not know this "AMMMMMMMMMMM"
    correctKey = "CHAMOMOCHACC";
    counter = 0;
  }

  /**
   * This function is created by Dr Ling, to extract the number of matched letters
   * @param guessedKey a String to compare with the Key
   * @return the number of matched letters
   *
   * Complexity: O(n)
   */
  public int guess(String guessedKey) {
    counter++;
    // validation
    if (guessedKey.length() != correctKey.length()) {
      return -1;
    }
    int matched = 0;
    for (int i = 0; i < guessedKey.length(); i++) { // O(n)
      char c = guessedKey.charAt(i);
      if (c != 'M' && c != 'O' && c != 'C' && c != 'H' && c != 'A') {
       return -1;
      }
      if (c == correctKey.charAt(i)) {
        matched++;
      }
    }
    if (matched == correctKey.length()) {
      System.out.println("Number of guesses: " + counter);
    }
    return matched;
  }

  public static void main(String[] args) {
    new SecretKeyGuesser().start();

  }
}
