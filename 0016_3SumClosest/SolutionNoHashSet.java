// time:    O(n^2)
// space:   O(n)

// idea:    Same idea as 0015.

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int ans = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          if (sum == target) {
              ans = target;
              break;
          } else if (target < sum) {
              while (left < right && nums[right] == nums[right - 1]) right--;
              right--;
          } else {
            // skip duplicates, taking advantage of sortedness
            while (left < right && nums[left] == nums[left + 1]) left++;
            left++;
          }
          if(Math.abs(target - sum) < Math.abs(target - ans)){
            ans = sum;
          }
        }
      }
    }
    return ans;
  }
}