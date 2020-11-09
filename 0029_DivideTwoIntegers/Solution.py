class Solution:
  def divide(self, dividend: int, divisor: int) -> int:
    quotient: int = 0
    sign: int = -1 if bool(dividend > 0) ^ bool(divisor > 0) else 1
    dividend = abs(dividend)
    divisor = abs(divisor)
    multiple: int
    temp: int
      
    while dividend >= divisor:
      multiple = 1
      temp = divisor
      while dividend >= temp << 1:
        temp <<= 1
        multiple <<= 1
      dividend -= temp
      quotient += multiple
    
    return min(2 ** 31 - 1, max(sign * quotient, -2 ** 31))