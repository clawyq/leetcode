// time:    O(1)
// space:   O(1)

// idea:    Just take note of the 'backtracking'.

class Solution {
  public int romanToInt(String s) {
    HashMap<Character, Integer> convert = new HashMap<>();
    convert.put('I', 1);
    convert.put('V', 5);
    convert.put('X', 10);
    convert.put('L', 50);
    convert.put('C', 100);
    convert.put('D', 500);
    convert.put('M', 1000);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      int num = convert.get(s.charAt(i));
      if (i > 0 && convert.get(s.charAt(i - 1)) < num) {
        ans = ans - 2 * convert.get(s.charAt(i - 1)) + num;
      } else {
        ans += num;   
      }
    }
    return ans;
  }
}