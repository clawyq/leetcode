class Solution:
  def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
    len1: int = len(nums1); len2: int = len(nums2)
    if len1 > len2:
      nums1, nums2, len1, len2 = nums2, nums1, len2, len1
      
    lowerBound: int = 0; upperBound: int = len(nums1)
    lowestInt = -sys.maxsize - 1
    while lowerBound <= upperBound:
      partition1: int = (upperBound + lowerBound) // 2
      partition2: int = (len1 + len2 + 1) // 2 - partition1
      
      nums1LeftHigh:int = nums1[partition1 - 1] if partition1 > 0 else lowestInt
      nums1RightLow:int = nums1[partition1] if partition1 != len1  else sys.maxsize
        
      nums2LeftHigh:int = nums2[partition2 - 1] if partition2 > 0 else lowestInt
      nums2RightLow:int = nums2[partition2] if partition2 != len2  else sys.maxsize
        
      if (nums1LeftHigh <= nums2RightLow) and (nums2LeftHigh <= nums1RightLow):
        if (len1 + len2) % 2 == 0:
          return (max(nums1LeftHigh, nums2LeftHigh) + min(nums1RightLow, nums2RightLow)) / 2
        else:
          return max(nums1LeftHigh, nums2LeftHigh)
      elif nums1LeftHigh > nums2RightLow :
          upperBound = partition1 - 1
      else:
          lowerBound = partition1 + 1
    return float(0)
