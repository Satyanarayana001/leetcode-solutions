class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int n = operations.length;
        for(int i = 0; i < n; i++){
            String op = operations[i];
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek()*2);
            }else if(op.equals("+")){
                int last = stack.pop();
                int secondlast = stack.peek();
                stack.push(last);
                stack.push(last+secondlast);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}