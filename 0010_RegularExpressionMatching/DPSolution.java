// time:    ? max number of recursive calls is bounded by O(T - i + P - 2j)
// space:   O(T^2 + P^2)

// idea:    Bottom up DP. We iterate towards 0 to not have to deal with 0-based indices.
//          Hence, text/pattern.length() just checks if there is still text/pattern.
//          i/j + 1 just means if the position before i/j. The logic is copy paste from the 
//          other solution.

class DPSolution {
  public boolean isMatch(String text, String pattern) {
    boolean[][] matches = new boolean[text.length() + 1][pattern.length() + 1];
    matches[text.length()][pattern.length()] = true;

    // moving downwards since i dont wanna deal with 0based indexes
    for (int i = text.length(); i >= 0; i--) {
      for (int j = pattern.length() - 1; j >= 0; j--) {
        
        boolean match = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
          matches[i][j] = match && matches[i + 1][j] || matches[i][j + 2];
        } else {
          matches[i][j] = match && matches[i + 1][j + 1];
        }
      }
    }
    return matches[0][0];
  }
}
