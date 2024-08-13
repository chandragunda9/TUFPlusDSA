package t1_beginner_problems.basic_strings;

public class RotateString {
    public static void main(String[] args) {
        String s = "abadae", goal = "aeabad";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        String concatString=s.concat(s);
        return concatString.contains(goal);
    }

    //This below code wont work because consider String s = "abadae", goal = "aeabad";
//    public static boolean rotateString(String s, String goal) {
//        int m = s.length(), n = goal.length();
//        if (m != n)
//            return false;
//        int right = 0;
//        char sFirstCharacter = s.charAt(0);
//
//        //getting the index where sFirstCharacter of s is equal to goal[index]
//        while (right < n && goal.charAt(right) != sFirstCharacter) {
//            right++;
//        }
//        if (right == n)
//            return false;
//
//        //now we got both l and r pointing to same character
//        int left = 0;
//        while (left < m) {
//            if (s.charAt(left) != goal.charAt(right))
//                return false;
//            left += 1;
//            right = (right + 1) % n;
//        }
//        return true;
//    }
}
