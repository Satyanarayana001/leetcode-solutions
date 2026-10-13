class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
               swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Return all elements that are not in the sorted list
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1)
                result.add(index + 1);
        }
        return result;
    }

    public static void swap(int[] nums, int i, int correctIndex){
         int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
    }

}