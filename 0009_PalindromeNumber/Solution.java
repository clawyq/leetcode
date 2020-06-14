// time:    O(lg(x))
// space:   O(1)

// idea:    Rebuild the 2nd half of the number as is. We are NOT doing it mirror-like so we can use equality
//          operator. If it is a number with odd number of digits, we can simply divide by 10 to get the floor.

class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    
    int secondHalfNumber = 0;
    while (secondHalfNumber < x) {
      secondHalfNumber = secondHalfNumber * 10 + x % 10;
      x /= 10;
    }   
    return x == secondHalfNumber || x == secondHalfNumber / 10;
  }
}