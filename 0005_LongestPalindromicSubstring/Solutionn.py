class Solution:
  def expand(self, s: str, left: int, right: int) -> int :
    while left > -1 and right < len(s) and (s[left] == s[right]):
      left -= 1
      right += 1
    return right - left - 1
  
  def longestPalindrome(self, s: str) -> str:
    if len(s) == 0:
      return ''
    start:int = 0; end:int = 0
    for i in range(len(s)):
      oddLengthPalindrome = self.expand(s, i, i)
      evenLengthPalindrome = self.expand(s, i, i + 1)
      longer:int = max(oddLengthPalindrome, evenLengthPalindrome)
      if (longer > end - start):
        start = i - ((longer - 1) // 2)
        end = i + (longer // 2)
    return s[start:end + 1]
