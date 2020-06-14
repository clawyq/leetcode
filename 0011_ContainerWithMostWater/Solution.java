// time:    O(n)
// space:   O(1)

// idea:    We don't want to slowly expand our container as it would be difficult to track if an
//          increase in area is due to a 'rightward' shift or a height change. 
//          Hence, we eliminate that ambiguity by starting with our container 'maxed' out horizontally.
//          This way, any increase in area will only be due to a height increase.
//          Also, we will always move the shorter pointer, since it is the limiting height factor.

class Solution {
  public int maxArea(int[] height) {
    int area = 0, left = 0, right = height.length - 1;
    while (left < right) {
      area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) {
        left++ 
      } else {
        right--;
      }
    }
    return area;
  }
}

