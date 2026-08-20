class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> stack2;

    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        int value = stack2.pop();

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }

        return value;
    }
    
    public int peek() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        int value = stack2.peek();

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }

        return value;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}