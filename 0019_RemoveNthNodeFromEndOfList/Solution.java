// time:    O(4^n), since in the worst case we have 4 new possible characters. Each press generates 4* what we have.
// space:   O(4^n)

// idea:    Enqueue all partial solutions, which builds into the final solution. To make life easier
//          with list indices, we gave 0 and 1 empty strings.

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {

    // we do this to not run into errors for listnodes with only 1 node
    ListNode ans = new ListNode(0);
    ListNode slow = ans, fast = ans;
    ans.next = head;

    // now the fast pointer is ahead by the required amount
    while (n >= 0) {
      fast = fast.next;
      --n;
    }

    // now our head is in the right place :)
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return ans;
  }
}