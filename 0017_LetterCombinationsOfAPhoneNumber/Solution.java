// time:    O(4^n), since in the worst case we have 4 new possible characters. Each press generates 4* what we have.
// space:   O(4^n)

// idea:    Enqueue all partial solutions, which builds into the final solution. To make life easier
//          with list indices, we gave 0 and 1 empty strings.

class Solution {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<>();
    if (digits.isEmpty())
      return ans;
    ans.add("");
    String[] letters = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    for (int i = 0; i < digits.length(); i++) {
      int digit = digits.charAt(i) - '0';
      while (ans.peek().length() == i) {
        String element = ans.remove();
        for (char c : letters[digit].toCharArray()) {
          ans.add(element + c);
        }
      }
    }
    return ans;
  }
}
