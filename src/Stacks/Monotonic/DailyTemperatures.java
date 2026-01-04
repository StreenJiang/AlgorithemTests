package Stacks.Monotonic;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek() - i;
            } else {
                results[i] = 0;
            }

            stack.push(i);
        }

        return results;
    }
}
