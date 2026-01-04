package Stacks;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        int previousTime = 0;
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] splits = log.split(":");
            int id = Integer.parseInt(splits[0]);
            String operation = splits[1];
            int time = Integer.parseInt(splits[2]);

            if ("start".equals(operation)) {
                if (!stack.isEmpty()) {
                    int topId = stack.peek();
                    result[topId] += time - previousTime;
                }
                stack.push(id);
                previousTime = time;
            } else {
                result[id] += time - previousTime + 1;
                stack.pop();
                previousTime = time + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // List<String> logs = List.of("0:start:0","1:start:2","1:end:5","0:end:6");
        // int n = 2;

        // List<String> logs = List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        // int n = 1;

        List<String> logs = List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        int n = 2;

        int[] ints = new ExclusiveTimeOfFunctions().exclusiveTime(n, logs);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
