class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int remt = 0;
        for(int i:nums){
            remt+=i;
        }
        return sum-remt;
    }
}