// time:    O(n)
// space:   O(1)

// idea:    take the last digit out and add it to a cumulative sum that is multiplied by 10 each time. 
//          Check for overflows.

class Solution {
  public int myAtoi(String str) {
    int answer = 0, index = 0, sign = 1;
    
    if (str.length() == 0) return 0;

    // takes away starting whitespaces - impt to take this out of main loop
    while (index < str.length() && str.charAt(index) == ' '){
      index++;
    }
    
    if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
      sign = str.charAt(index) == '-' ? -1 : 1;
      index++;
    }
    
    while(index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9) {
        break;
      }
      if (answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE / 10 && digit > 7)) {
        return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      answer = answer * 10 + digit;
      index++;
    }
    
    return sign * answer;
  }
}