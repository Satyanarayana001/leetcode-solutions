class MyStack {
    Queue<Integer> queue;
    Queue<Integer> que;
    public MyStack() {
        queue = new ArrayDeque<>();
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.offer(x);
        while(!queue.isEmpty()){
            que.offer(queue.poll());
        }
        Queue<Integer> temp = queue;
        queue = que;
        que = temp;
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */