package t11_stacks_queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        return st.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] ast = {10, -10};
        AsteroidCollision obj = new AsteroidCollision();
        System.out.println(Arrays.toString(obj.asteroidCollision(ast)));
    }
}
