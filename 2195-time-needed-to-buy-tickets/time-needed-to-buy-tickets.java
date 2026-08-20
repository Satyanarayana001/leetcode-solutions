class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<tickets.length;i++){
            queue.offer(i);
        }
        int time = 0;
        while(!queue.isEmpty()){
                int a = queue.poll();
                tickets[a]--;
                time++;
                if(tickets[a]>0){
                    queue.offer(a);
                }
            if(tickets[k]==0){
                return time;
            }
        }
        return time;
    }
}