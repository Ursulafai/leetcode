public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode secondPart = slowPointer.next;
        slowPointer.next = null;

        ListNode prev = null;
        ListNode current = secondPart;

        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
        }

        ListNode first = head;
        ListNode secondReversed = prev;

        while (secondReversed != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = secondReversed.next;

            first.next = secondReversed;
            secondReversed.next = nextFirst;

            first = nextFirst;
            secondReversed = nextSecond;
        }
    }
}
