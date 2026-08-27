/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap sorted by the node's value
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Step 1: Add the head of each non-empty list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Step 2: Pop the smallest element and push its next element
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                heap.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
