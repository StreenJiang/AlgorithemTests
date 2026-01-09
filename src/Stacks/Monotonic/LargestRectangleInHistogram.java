package Stacks.Monotonic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        List<Integer> heightList = new ArrayList<>();
        for (int h : heights) {
            heightList.add(h);
        }
        heightList.add(0);
        int[] extendedHeights = heightList.stream().mapToInt(i -> i).toArray();

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < extendedHeights.length; i++) {
            while (!stack.isEmpty() && extendedHeights[i] < extendedHeights[stack.peek()]) {
                int h = extendedHeights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
