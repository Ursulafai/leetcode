import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        int k = 0;
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);

                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decodedString = new StringBuilder();
                decodedString.append(stringStack.pop());

                int count = countStack.pop();

                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }

                currentString = decodedString;
            } else {
                currentString.append(ch);
            }

        }

        return currentString.toString();

    }
}
