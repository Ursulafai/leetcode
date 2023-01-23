import java.util.*;

public class Main {
    public static void main(String[] args) {
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static boolean isPalindromeWithCastToString(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - (i + 1)])
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;

        int newNum = 0;
        while (x > newNum) {
            newNum = newNum * 10 + x % 10;
            x /= 10;
        }

        return x == newNum || x == newNum / 10;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j++) {
                if (!(strs[j].startsWith(commonPrefix.toString() + strs[0].charAt(i)))) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strs[0].charAt(i));
        }

        return commonPrefix.toString();
    }

    public static boolean isValidParentheses(String s) {
        Map<Character, Character> openedToClosed = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (openedToClosed.containsKey((s.charAt(i)))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                else if (openedToClosed.get(stack.peek()).equals(s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return list1;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;


        ListNode finishList = new ListNode();
        ListNode newNode = new ListNode();

        if (list1.val > list2.val) {
            newNode.val = list2.val;

            list2 = list2.next;
        } else {
            newNode.val = list1.val;

            list1 = list1.next;
        }

        finishList = newNode;

        while (list1 != null && list2 != null) {
            ListNode listNode = new ListNode();

            if (list1.val > list2.val) {
                listNode.val = list2.val;

                list2 = list2.next;
            } else {
                listNode.val = list1.val;

                list1 = list1.next;
            }

            newNode.next = listNode;
            newNode = listNode;
        }

        if (list1 == null) {
            ListNode listNode = new ListNode();

            listNode = list2;

            newNode.next = listNode;
        } else if (list2 == null) {
            ListNode listNode = new ListNode();

            listNode = list1;

            newNode.next = listNode;
        }

        return finishList;
    }
}