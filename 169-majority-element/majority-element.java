class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length/2;
        for(int num : nums){
            int count = 0;
            for(int x: nums){
                if(x == num){
                    count++;
                }
            }
            if(count > n){
                return num;
            }
        }
        return -1;
    }
}