// time:    O(n)
// space:   O(1)

// idea:    Super straightforward, take note of what is the current number and have a skip counter that increments
//          if the next value is that.
//          Alternative solution, just have a fast pointer sprint through the array. Update slow pointer and its value
//          when a new value is encountered.

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int currNum = nums[0], skipped = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == currNum) {
        skipped++;
        continue;
      } 
      currNum = nums[i];
      nums[i - skipped] = nums[i];
    }
    return nums.length - skipped;
  }

  public int removeDuplicates2Pointers(int[] nums); {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) nums[++i] = nums[j];
    }
    return i + 1;
  }
}
