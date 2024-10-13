package t11_stacks_queues.faqs;

public class CelebrityProblem {
    public int celebrity(int[][] M) {
        int top = 0, down = M.length - 1;
        while (top < down) {
            if (M[top][down] == 1) {
                //if top knows down, top is not a celeb
                top++;
            } else if (M[down][top] == 1) {
                //if down knows top, down is not a celeb
                down--;
            } else {
                top++;
                down--;
            }
        }

        if (top > down)
            return -1;
        for (int i = 0; i < M.length; i++) {
            if (top == i)
                continue;
            if (M[top][i] == 1 || M[i][top] == 0)
                return -1;
        }
        return top;
    }

    public int method1(int[][] M) {
        int n = M.length;
        int[] knowMe = new int[n];
        int[] iKnow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (knowMe[i] == n - 1 && iKnow[i] == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 0}};
        CelebrityProblem obj = new CelebrityProblem();
        System.out.println(obj.method1(arr));
        System.out.println(obj.celebrity(arr));
    }
}
