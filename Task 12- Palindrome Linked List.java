
class Solution12 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
 
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow.next);

        ListNode firstHalfPtr = head;
        ListNode secondHalfPtr = secondHalfHead;
        boolean isPalindrome = true;
        
        while (isPalindrome && secondHalfPtr != null) {
            if (firstHalfPtr.val != secondHalfPtr.val) {
                isPalindrome = false;
            }
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr = secondHalfPtr.next;
        }

        slow.next = reverseList(secondHalfHead);
        
        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
