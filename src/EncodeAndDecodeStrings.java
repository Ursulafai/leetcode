import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + 1 + length);
            res.add(s);

            i = j + 1 + length;
        }

        return res;
    }
}
