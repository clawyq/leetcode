// time:    O(log(x))
// space:   O(1)

// idea:    take the last digit out and add it to a cumulative sum that is multiplied by 10 each time. 
//          Check for overflows.

class Solution {
   public int reverse(int x) {
    int answer = 0;
    while (x != 0) {
      int lastDigit = x % 10;
      x /= 10;
      if (answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE / 10 && lastDigit > 7)) return 0;
      if (answer < -Integer.MIN_VALUE / 10 || (answer == Integer.MIN_VALUE / 10 && lastDigit < -8)) return 0;
      
      answer = answer * 10 + lastDigit;
    }
    return answer;
  }
}