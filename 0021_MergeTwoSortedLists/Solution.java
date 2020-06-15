// time:    O(min(n, m))
// space:   O(max(n, m))

// idea:    Simple iterative solution that just goes through both lists. Just check our guard clauses.
//          A recursive solution while shorter, might run into stack problems for laaaaaaarge input.

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    else if(l2 == null) return l1;
    ListNode ans = new ListNode(0);
    ListNode curr = ans;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    curr.next = l1 == null ? l2 : l1;
    return ans.next;
  }
}