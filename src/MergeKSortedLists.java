public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoSortedLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];

    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}
