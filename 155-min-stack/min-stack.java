class MinStack {
    Stack<Integer> org;
    Stack<Integer> minStack;
    public MinStack() {
        org = new Stack();
        minStack = new Stack();
    }
    
    public void push(int value) {
        org.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            int minValue = Math.min(value, minStack.peek());
            minStack.push(minValue);
        }
    }
    
    public void pop() {
        org.pop();
        minStack.pop();
    }
    
    public int top() {
        return org.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */