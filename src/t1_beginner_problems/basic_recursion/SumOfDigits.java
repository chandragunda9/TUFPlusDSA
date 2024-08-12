package t1_beginner_problems.basic_recursion;

public class SumOfDigits {
    public int addDigits(int num) {
        if (num < 10)
            return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
        /*
         * Time Complexity O(log n) – This is because each recursive call processes a number with fewer digits than the previous call, leading to logarithmic time complexity in terms of the number of digits.
         * */
    }
}
