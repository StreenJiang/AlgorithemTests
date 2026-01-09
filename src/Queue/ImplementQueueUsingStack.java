package Queue;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public class MyQueue {
        Stack<Integer> inputStack;
        Stack<Integer> outputStack;

        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            if (outputStack.isEmpty()) {
                transfer();
            }
            return outputStack.pop();
        }

        public int peek() {
            if (outputStack.isEmpty()) {
                transfer();
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        private void transfer() {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
