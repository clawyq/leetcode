// time:    O(n)
// space:   O(1)

// idea:    Just make sure of our indices. We start from position '0'.

class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode sol = new ListNode(0), currPtr = sol;
    currPtr.next = head;
    while (currPtr.next != null && currPtr.next.next != null) {
      ListNode first = currPtr.next;
      ListNode second = currPtr.next.next;
      first.next = second.next;
      second.next = first;
      currPtr.next = second;
      currPtr = currPtr.next.next;
    }
    return sol.next;
  }
}
