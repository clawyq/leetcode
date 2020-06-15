// time:    O(n)
// space:   O(1)

// idea:    Simple stack solution. Alternatively we could have coded a switch case to save on the HashMap overhead but I'm lazy.

class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 == 1) return false;
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> braces = new HashMap<>() {
      {
        put(')', '(');
        put(']', '[');
        put('}', '{');
      }
    };
    for (char c : s.toCharArray()) {
      if (braces.containsKey(c)) {
        if (stack.isEmpty() || stack.peek() != braces.get(c)) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}