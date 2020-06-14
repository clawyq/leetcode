// time:    ? max number of recursive calls is bounded by O(T - i + P - 2j)
// space:   O(T^2 + P^2)

// idea:    Recursively go through the pattern and the text. If match with no Kleene star, just proceed
//          with 1st char omitted from both text and pattern. If there is a Kleene star, you could proceed 
//          with no match and cut out the Kleene star from the pattern, or cut out the match from the text
//          and the existing pattern.

class Solution {
  public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean match = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (match && isMatch(text.substring(1), pattern)) || isMatch(text, pattern.substring(2));
    }

    return match && isMatch(text.substring(1), pattern.substring(1));
  }
}