package t9_greedy.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findMaximumCookieStudents(int[] students, int[] cookies) {
        Arrays.sort(students);
        Arrays.sort(cookies);

        int l = 0, r = 0;
        while (l < cookies.length && r < students.length) {
            if (cookies[l] >= students[r]) {
                l++;
                r++;
            } else if (cookies[l] < students[r]) {
                l++;
            }
        }
        return r;
    }
}
