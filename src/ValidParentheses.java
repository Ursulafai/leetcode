import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(("));
    }

    static class Solution {
        Map<Character, Character> bracesMap = Map.of(']', '[', '}', '{', ')', '(');
        Stack<Character> stack = new Stack<>();

        public boolean isValid(String s) {
            if (s.length() % 2 > 0) return false;

            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() &&
                        bracesMap.getOrDefault(s.charAt(i), '?').equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

            return stack.isEmpty();
        }
    }
}
