package Stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        String plus = "+";
        String minus = "-";
        String multiply = "*";
        String divide = "/";
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            try {
                int currNum = Integer.parseInt(token);
                stack.push(currNum);
            } catch (Exception _) {
                Integer operand_back = stack.pop();
                Integer operand_front = stack.pop();

                if (plus.equals(token)) {
                    stack.push(operand_front + operand_back);
                } else if (minus.equals(token)) {
                    stack.push(operand_front - operand_back);
                } else if (multiply.equals(token)) {
                    stack.push(operand_front * operand_back);
                } else if (divide.equals(token)) {
                    stack.push(operand_front / operand_back);
                }
            }
        }

        return stack.pop();
    }
}
