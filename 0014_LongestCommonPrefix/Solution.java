// time:    O(nm), where n is number of strings and m is the characters
// space:   O(1)

// idea:    As we go through the strings, make sure all of them comply with our prefix.
//          If they don't, chop the last character and retry until passing before moving on.

class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }
}
