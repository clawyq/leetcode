class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    solutionList: List[int] = []
    complementMap: Dict[int, int] = {}
    for i, num in enumerate(nums):
      complement: int = target - num
      if complement in complementMap:
        solutionList = [complementMap[complement], i]
        break;
      complementMap[nums[i]] = i
    return solutionList
