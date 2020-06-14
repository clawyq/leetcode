// time:    O(n)
// space:   O(n)

// idea:    let the complements of a number x be target - x. As we iterate through the array, 
//          add the complement of x to a hashmap. The moment we see a number in the hashmap, we
//          have found the pair of numbers.

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] solutionArray = new int[2];
    HashMap<Integer, Integer> complementMap = new HashMap<>();
    
    for (int i = 0; i < nums.length; i ++) {
      if (complementMap.containsKey(target - nums[i])) {
        solutionArray[0] = complementMap.get(target - nums[i]);
        solutionArray[1] = i;
        break;
      } 
      complementMap.put(nums[i], i);
    }
    return solutionArray;
  }
}