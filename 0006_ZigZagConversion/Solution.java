// time:    O(n)
// space:   O(n)

// idea:    Add to the answer string row by row. When iterating over the string, add the easy characters (along the columns)
//          then consider the diagonal case.

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    int cycle = numRows * 2 - 2;
    StringBuilder answer = new StringBuilder();
    // for each row
    for (int i = 0; i < numRows; i++) {
      // 'seeded at the ith row', look at the characters that belong in the ith row
      for (int j = 0; i + j < s.length(); j += cycle) {
        answer.append(s.charAt(i + j));
        // to add the numbers on the diagonal
        // since the diagonal is shaped like this (/), add 1 cycle and - the row number
        if (i != 0 & i != numRows - 1 && j + cycle - i < s.length()) {
          answer.append(s.charAt(j + cycle - i));
        }
      }
    }
    return answer.toString();
  }
}