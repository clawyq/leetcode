class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    solutionList: List[int] = []
    complementMap: Dict[int, int] = {}
    for index in range(len(nums)):
      complement: int = target - nums[index]
      if complement in complementMap:
        solutionList = [complementMap[complement], index]
        break;
      complementMap[nums[index]] = index
    return solutionList
