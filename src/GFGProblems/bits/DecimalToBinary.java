package GFGProblems.bits;

public class DecimalToBinary {
    void toBinary(int N) {
        StringBuilder res = new StringBuilder();
        while (N > 0) {
            res.insert(0, N % 2);
            N = N / 2;
        }
        System.out.print(res);
        //time; O(logn)
        //space: O(logn)
    }

    public static void main(String[] args) {
        DecimalToBinary obj = new DecimalToBinary();
        int n = 13;
        obj.toBinary(n);
    }
}
