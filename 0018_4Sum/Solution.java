// time:    O(n^3)
// space:   O(n)

// idea:    We've done 3Sum. This is a generalised solver for the kSum problem by using the same ideas there, so the
//          main work here is in the else clause as we try to reduce it to a 2Sum. Time complexity is O(n^(k - 1)).

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSumSolver(nums, target, 0, 4);
  }

  private List<List<Integer>> kSumSolver(int[] nums, int target, int anchorIndex, int k) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (k == 2) {
      int left = anchorIndex, right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
          ans.add(new ArrayList<Integer>(Arrays.asList(nums[left], nums[right])));
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          left++; right--;
        } else if (sum > target) right--;
          else left++;
      }
    } else {
      // reduce to 2Sum
      for (int i = anchorIndex; i < nums.length - (k - 1); i++) {
        // skip duplicate anchors
        if (i > anchorIndex && nums[i] == nums[i - 1]) continue;
        List<List<Integer>> subAns = kSumSolver(nums, target - nums[i], i + 1, k - 1);
        // populate the anchor
        for (List<Integer> list : subAns) {
          list.add(0, nums[i]);
        }
        ans.addAll(subAns);
      }
    }
    return ans;
  }
}
