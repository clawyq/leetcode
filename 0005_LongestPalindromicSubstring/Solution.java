// time:    O(n^2)
// space:   O(1)

// idea:    We have no idea where each palindrome is, so we verify a palindrome by treating each
//          character as the center. This verification is done by expansion. Notice the expansion function
//          'expands before checking', so we need to have the - 1 there.

class Solution {
  public String longestPalindrome(String s) {
    if (s.length() == 0) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int oddPalindromeLen = expansion(s, i, i);
      int evenPalindromeLen = expansion(s, i, i + 1);
      int longerPalindrome = Math.max(oddPalindromeLen, evenPalindromeLen);
      if (longerPalindrome > end - start) {
        start = i - ((longerPalindrome - 1) / 2);
        end = i + (longerPalindrome / 2);
      }
    }
    return s.substring(start, end + 1);
  }
  
  private int expansion(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}