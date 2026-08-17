class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        for(int right = 1; right < nums.length; right ++){
            if(nums [left] == nums [right])
            {
                return true;
            }
            left++;
        }
        return false;
    }
}