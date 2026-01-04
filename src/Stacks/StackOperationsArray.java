package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOperationsArray {
    public List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";

        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            result.add(push);

            if (i == target[index]) {
                index++;

                if (target.length == stack.size()) {
                    break;
                }
            } else {
                stack.pop();
                result.add(pop);
            }
        }

        return result;
    }
}
