// time:    O(log(min(m, n)))
// space:   O(1)

// idea:    Maintain a left set and right set WITHOUT merging and sorting, since if we have
//          found the correct partitions, we just need to compare the numbers on either sides 
//          of the partitions to get our median.
// 
//          To find the best partition, we do a binary search on the smaller array, terminating
//          the search only when the 2 biggest elements on the left partition (1 from each array) 
//          are both smaller than the 2 smallest element on the right partition (1 from each array).

class Solution {
  public double findMedianSortedArrays(int[] A, int[] B) {
    int lengthA = A.length;
    int lengthB = B.length;

    // swapping to ensure that we will be binary searching on the smaller array
    if (lengthA > lengthB) {
        int[] temp = A; A = B; B = temp;
      int tmp = lengthA; lengthA = lengthB; lengthB = tmp;
    }

    // bsearch to find partition for smaller array
    int lowBound = 0, highBound = lengthA;
    while (lowBound <= highBound) {
      int partitionA = (lowBound + highBound) / 2;
      // to ensure elements on both sides of partitions are equal, or nLeft = nRight + 1
      int partitionB = (lengthA + lengthB + 1) / 2 - partitionA; 

      // in case there are empty partitions
      // partitions are placed in between elements; therefore - 1.
      int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
      int minRightA = (partitionA == lengthA) ? Integer.MAX_VALUE : A[partitionA];

      int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
      int minRightB = (partitionB == lengthB) ? Integer.MAX_VALUE : B[partitionB];

      if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
        if ((lengthA + lengthB) % 2 == 0) { 
          //even length array
          return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
        } else {
          // since we have ensured that left will have more elements
          return (double)Math.max(maxLeftA, maxLeftB); 
        }
      } else if (maxLeftA > minRightB) { 
        // left partition too big; iterate on the smaller side of bsearched array
        highBound = partitionA - 1;
      } else { 
        // right partition too small; iterate on the bigger side of bsearched array
        lowBound = partitionA + 1;
      }
    }
    return 0.0;
  }
}