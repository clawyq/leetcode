// time:    O(nlg(k)), where n is the max number of nodes in any 2 paired lists and k is the num of lists  
// space:   O(1), space is recycled.

// idea:    Divide and Conquer - divide into pairs that are to be merged. Take that as a partial solution
//          for subsequent divide steps. The pairingInterval denotes how far away my pair is, and when we
//          recycle the list, the distance between each pair is twice that of the pairingInterval.

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    int pairingInterval = 1;
    while (pairingInterval < lists.length) {
      // the distance between each pair doubles
      for (int i = 0; i + pairingInterval < lists.length; i += pairingInterval * 2) { 
        lists[i] = merge2Lists(lists[i], lists[i + pairingInterval]);
      }
      pairingInterval *= 2;
    }
    return lists[0];
  }

  private ListNode merge2Lists(ListNode l1, ListNode l2) {
    ListNode sol = new ListNode(0), currPtr = sol;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        currPtr.next = l1;
        l1 = l1.next;
      } else {
        currPtr.next = l2;
        l2 = l2.next;
      }
      currPtr = currPtr.next;
    }
    currPtr.next = (l1 == null) ? l2 : l1;
    return sol.next;
  }
}