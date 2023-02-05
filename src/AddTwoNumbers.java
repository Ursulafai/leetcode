public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode seventhNodL1 = new ListNode(9);
        ListNode sixthNodL1 = new ListNode(9, seventhNodL1);
        ListNode fifthNodL1 = new ListNode(9, sixthNodL1);
        ListNode fourthNodL1 = new ListNode(9, fifthNodL1);
        ListNode thirdNodeL1 = new ListNode(9, fourthNodL1);
        ListNode secondNodeL1 = new ListNode(9, thirdNodeL1);
        ListNode oneNodL1 = new ListNode(9, secondNodeL1);

        ListNode fourthNodeL2 = new ListNode(9);
        ListNode thirdNodeL2 = new ListNode(9, fourthNodeL2);
        ListNode secondNodeL2 = new ListNode(9, thirdNodeL2);
        ListNode oneNodL2 = new ListNode(9, secondNodeL2);

        System.out.println(addTwoNumbers(oneNodL1, oneNodL2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int oneToShift = 0;
        ListNode tailNode = new ListNode();

        int tailNum = l1.val + l2.val;

        ListNode firstNode = new ListNode();

        if (tailNum > 9) {
            firstNode.val = tailNum % 10;
            oneToShift = 1;

        } else {
            firstNode.val = tailNum;
        }

        tailNode.next = firstNode;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            tailNum = l1.val + l2.val;
            if (oneToShift == 1) {
                tailNum++;
                oneToShift = 0;
            }
            ListNode currentNode = new ListNode();

            if (tailNum > 9) {
                currentNode.val = tailNum % 10;
                oneToShift = 1;

            } else {
                currentNode.val = tailNum;
            }

            firstNode.next = currentNode;


            l1 = l1.next;
            l2 = l2.next;

            firstNode = firstNode.next;

        }

        if (l1 == null) {
            sum(l2, oneToShift, tailNum, firstNode);
        } else {
            sum(l1, oneToShift, tailNum, firstNode);
        }

        return tailNode.next;
    }

    private static void sum(ListNode list, int oneToShift, int tailNum, ListNode firstNode) {
        while (list != null) {
            int remainingNum = list.val;
            if (oneToShift == 1) {
                remainingNum++;
                oneToShift = 0;
            }
            ListNode newNode = new ListNode();
            if (remainingNum > 9) {
                newNode.val = 0;
                oneToShift = 1;

            } else {
                newNode.val = remainingNum;
            }

            firstNode.next = newNode;

            list = list.next;
            firstNode = firstNode.next;
        }

        if (oneToShift == 1) {
            firstNode.next = new ListNode(1);
        }
    }
}
