// time:    O(n)
// space:   O(1) as required

// idea:    We are essentially splitting the problem until we can reuse the swapping in pairs logic.
//          We also need to maintain more pointers to hold references to the list nodes that are 
//          not being swapped yet. 

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head.next == null) return head;
    ListNode sol = new ListNode(0), next = sol, curr = sol, prev = sol;
    sol.next = head;
    int count = 0;
    while (curr.next != null) {
      curr = curr.next;
      count++;
    }
    while (count >= k) {
      curr = prev.next;
      next = curr.next;
      for (int i = 1; i < k; i++) {
        // holds the reference to the next for now
        curr.next = next.next;
        // swap
        next.next = prev.next;
        prev.next = next;
        // advance
        next = curr.next;
      }
      prev = curr;
      count -= k;
    }
    return sol.next;
  }
}
