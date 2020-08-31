// time:    O(n)
// space:   O(1)

// idea:    Have a fast pointer sprint through the array. Update slow pointer and its value when a 
//          value != k is encountered.

class Solution {
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) nums[i++] = nums[j];
    }
    return i;
  }
}
