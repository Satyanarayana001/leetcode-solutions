class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int count = 1;
        int lc = 1;

        for(int i = 1; i < nums.length; i++){

            if(nums[i] == nums[i - 1] + 1){
                count++;
            }
            else if(nums[i] != nums[i - 1]){
                count = 1;
            }

            lc = Math.max(lc, count);
        }

        return lc;
    }
}