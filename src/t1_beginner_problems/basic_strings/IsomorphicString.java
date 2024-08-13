package t1_beginner_problems.basic_strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public boolean isomorphicString(String s, String t) {
        Map<Character, Character> stMapping = new HashMap<>();
        Map<Character, Character> tsMapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (stMapping.containsKey(ch1) && stMapping.get(ch1) != ch2)
                return false;
            stMapping.put(ch1, ch2);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch1 = t.charAt(i);
            char ch2 = s.charAt(i);
            if (tsMapping.containsKey(ch1) && tsMapping.get(ch1) != ch2)
                return false;
            tsMapping.put(ch1, ch2);
        }
        return true;
    }
}
