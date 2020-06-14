// time:    O(n)
// space:   O(n)

// idea:    Sliding window with the help of a hashmap to record the index of each character.
//          As we iterate through the array, we slide the right pointer. The moment we encounter
//          a duplicate element, we move the left pointer to the max of :
//              1) the right of the character we have just seen with our right pointer
//              2) don't move at all.
//          We need the max as the duplicate we are encountering may be on the left of our left pointer,
//          i.e. outside our window. Eg: "abba".

class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> charMap = new HashMap<>();
    int max = 0;
    
    for (int left = 0, right = 0; right < s.length(); right++) {
      if (charMap.containsKey(s.charAt(right))) {
        left = Math.max(charMap.get(s.charAt(right)) + 1, left);
      }
      
      charMap.put(s.charAt(right), right);
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}