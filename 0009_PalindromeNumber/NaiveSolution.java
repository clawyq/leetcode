// time:    O(len(n))
// space:   O(1)

// idea:    Convert to a string and then check for palindrome-ness.

class NaiveSolution {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    String s = String.valueOf(x);
    int middleIndex = (s.length() - 1) / 2;
    int left = middleIndex, right = s.length() % 2 == 0 ? middleIndex + 1 : middleIndex;
    while (left >= 0 && right < s.length()) {
        if (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;            
        } else {
         return false;   
        }
    }
    return true;
  }
}