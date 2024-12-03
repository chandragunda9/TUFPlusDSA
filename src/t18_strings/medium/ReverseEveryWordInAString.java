package t18_strings.medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseEveryWordInAString {
    public String method1(String s) {
        List<String> words = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= n) break;

            int start = i;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            words.add(s.substring(start, end + 1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = words.size() - 1; j >= 0; j--) {
            stringBuilder.append(words.get(j));
            if (j != 0) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

    void reverseString(char[] arr, int i, int j) {
        while (i < j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        int i = 0, j = 0, start = 0, end = 0;
        int n = s.length();
        char[] arr = s.toCharArray();

        reverseString(arr, 0, n - 1);

        while (j < n) {
            while (j < n && arr[j] == ' ') j++;
            start = i;
            while (j < n && arr[j] != ' ') {
                arr[i] = arr[j];
                j++;
                i++;
            }
            end = i - 1;

            reverseString(arr, start, end);
            if (i < n)
                arr[i++] = ' ';
        }

        return new String(arr).substring(0, end + 1);
    }

    public static void main(String[] args) {
        String s = "welcome to the jungle";
        ReverseEveryWordInAString obj = new ReverseEveryWordInAString();
        System.out.println(obj.reverseWords(s));
    }
}
