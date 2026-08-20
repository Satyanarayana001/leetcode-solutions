class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        if(students.length != sandwiches.length){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < students.length; i++){
            queue.offer(students[i]);
        }
        for(int j = sandwiches.length-1; j >= 0; j--){
            stack.push(sandwiches[j]);
        }
        int count = 0;
        /*if(queue.peek() == stack.peek()){
            count++;
            return count;
        }else{
            queue.offer(queue.poll());
        }
        */
        while (!queue.isEmpty() && count < queue.size()) {

            if (queue.peek().equals(stack.peek())) {

                queue.poll();  // student eats
                stack.pop();   // sandwich removed

                count = 0;     // reset because someone ate

            } else {

                queue.offer(queue.poll()); // move student to back
                count++;
            }
        }

        return queue.size();
    }
}