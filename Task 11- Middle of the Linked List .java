// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }
    
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class Solution11 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Fast pointer moves twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // When fast reaches the end, slow is at the middle
        return slow;
    }

    // Boilerplate code to test the solution locally
    public static void main(String[] args) {
        Solution11 solver = new Solution11();

        // Example 1:
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode mid1 = solver.middleNode(head1);
        System.out.print("Example 1 Output: ");
        printList(mid1); // Expected: [3, 4, 5]

        // Example 2:
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode mid2 = solver.middleNode(head2);
        System.out.print("Example 2 Output: ");
        printList(mid2); // Expected: [4, 5, 6]
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        // FIXED: Changed 'arr' to 'arr[0]' to pass the first integer element
        ListNode head = new ListNode(arr[0]); 
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print the linked list
    private static void printList(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(", ");
            }
            node = node.next;
        }
        System.out.println("]");
    }
}
