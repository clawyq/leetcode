// time:    O(n^2)
// space:   O(n)

// idea:    We use a set to  keep out duplicates. Since we have to play 3 variables and that would be at
//          least be a n^2 complexity, we take advantage of nlg(n) sorts. We then loop through the array
//          and use 2 sliding pointers to calculate a sum. Since they are now sorted, we can shift the 
//          relevant pointer accordingly to bring our sum closer to 0.

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) return new ArrayList<List<Integer>>();
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) set.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
        else if (sum > 0) right--;
        else left++;
      }    
    }
    return new ArrayList<>(set);
  }
}