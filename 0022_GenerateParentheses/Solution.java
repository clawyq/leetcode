// time:    O(2^n) I have 2 options each time, and in the worst case they grow n deep
// space:   O(2n)

// idea:    Simple stack (DFS) solution. We throw out strings that violate the rules and make sure we only add 
//          correct ones.

class Solution {
  private class BracketInfo {
    public String str;
    public int left, right;

    public BracketInfo(String str, int left, int right) {
      this.str = str;
      this.left = left;
      this.right = right;
    }
  }

  public List<String> generateParenthesis(int n) {
    ArrayList<String> ans = new ArrayList<>();
    Stack<BracketInfo> stack = new Stack<>();
    stack.push(new BracketInfo("(", 1, 0));
    while (!stack.isEmpty()) {
      BracketInfo info = stack.pop();
      String str = info.str;
      int left = info.left, right = info.right;
      if (left - right < 0 || left > n || right > n) continue; //discard
      if (left == n && right == n) ans.add(str.toString());
      stack.push(new BracketInfo(str + "(", left + 1, right));
      stack.push(new BracketInfo(str + ")", left, right + 1));
    }
    return ans;
  }
}