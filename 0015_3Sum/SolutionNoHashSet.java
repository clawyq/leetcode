// time:    O(n^2)
// space:   O(n)

// idea:    Same logic as before, but without the use of a hashset.

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (nums.length < 3) return ans;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
        int left = i + 1, right = nums.length - 1, target = 0 - nums[i];
        while (left < right) {
          if (target == nums[left] + nums[right]) {
            ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
            // skip duplicates, taking advantage of sortedness
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            // need to actually move on
            left++;
            right--;
          } else if (target < nums[left] + nums[right]) right--;
            else left++;
        }
      }
    }
    return ans;
  }
}
