package t1_beginner_problems.basic_recursion;

import java.util.Vector;

public class ReverseAString {
    public Vector<Character> reverseString(Vector<Character> s) {
//        if (s == null || s.isEmpty())
//            return s;
//        swap(s, 0, s.size() - 1);
//        return s;

        int left = 0, right = s.size() - 1;
        while (left < right) {
            Character temp = s.get(left);
            s.set(left, s.get(right));
            s.set(right, temp);
            left++;
            right--;
        }
        return s;
    }

    void swap(Vector<Character> s, int left, int right) {
        if (left >= right)
            return;
        Character temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);
        swap(s, ++left, --right);
    }
}
