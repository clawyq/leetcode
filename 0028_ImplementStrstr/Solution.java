// time:    O(nm) can be improved https://leetcode.com/problems/implement-strstr/discuss/304532/O(M-%2B-N)-SOLUTION-KMP-ALGORITHM
// space:   O(1)

// idea:    Just check. What else is there to say.

class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) return 0;
    for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
      for (int j = 0; j < needle.length(); j++) {
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
        if (j == needle.length() - 1) return i;
      }
    }
    return -1;
  }
}
