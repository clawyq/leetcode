class Solution:
  def lengthOfLongestSubstring(self, s: str) -> int:
    tokenised: List[str] = list(s)
    seen: Dict[str, int] = {}
      
    leftWin: int = 0; rightWin: int = 0; longest:int = 0
    for rightWin, char in enumerate(tokenised):
      if char in seen:
        leftWin = max(leftWin, seen[char] + 1)
      
      seen[char] = rightWin
      longest = max(longest, rightWin - leftWin + 1)
    return longest
