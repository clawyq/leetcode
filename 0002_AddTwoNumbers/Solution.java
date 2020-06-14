// time:    O(max(m + n))
// space:   O(max(m + n)

// idea:    add as we would in kindergarten. Hold a variable for a carry, and watch out for edge
//          cases like if the 2 lists are not of the same length.

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode pointer1 = l1;
    ListNode pointer2 = l2;
    ListNode answer = new ListNode(0);
    ListNode answerPointer = answer;
    int sum = 0;
    while (pointer1 != null || pointer2 != null) {
      sum /= 10; 

      // these checks are for different length of listnodes
      if (pointer1 != null) {
        sum += pointer1.val;
        pointer1 = pointer1.next;
      }
      if (pointer2 != null) {
        sum += pointer2.val;
        pointer2 = pointer2.next;
      }

      // for the next number
      answerPointer.next = new ListNode(sum % 10);
      answerPointer = answerPointer.next;
    }

    if (sum / 10 == 1) answerPointer.next = new ListNode(1);
    return answer.next;
  }
}