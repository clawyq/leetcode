// time:    O(nlg(k)), where n is the total number of elements and k is the num of lists  
// space:   O(1), space is recycled.

// idea:    PQ Heap - Throw the first elements into a PQ and let it do some mumbo jumbo in lg(k) time for
//          quick poll and add operations. Btw bubble up and down is lg(k) because in the worst case we
//          don't have to compare it to the largest(bottom) row of elements. I think.

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    Comparator<ListNode> cmp = new Comparator<>() {
      @Override
      public int compare(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
      }
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);
    for (int i = 0; i < lists.length; i ++) {
      pq.add(lists[i]);
    }
    ListNode sol = new ListNode(0), currPtr = sol;
    while (!pq.isEmpty()) {
      currPtr.next = pq.poll();
      currPtr = currPtr.next;
      ListNode next = currPtr.next;
      if (next != null) {
        pq.add(next);
      }
    }
    return sol.next;
  }
