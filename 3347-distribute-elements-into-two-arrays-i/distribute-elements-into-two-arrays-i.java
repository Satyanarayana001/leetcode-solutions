class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        
        // Pre-allocate standard primitive arrays to avoid boxing overhead
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        // Track the current size (and next insertion index) of each array
        int size1 = 0;
        int size2 = 0;
        
        // Seed the initial elements
        arr1[size1++] = nums[0];
        arr2[size2++] = nums[1];
        
        // Distribute elements using basic index pointers
        for (int i = 2; i < n; i++) {
            // Read the last inserted elements directly by index
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }
        
        // Re-use the input array 'nums' as the result to achieve O(1) extra space!
        // Copy arr1 elements back into nums
        for (int i = 0; i < size1; i++) {
            nums[i] = arr1[i];
        }
        // Copy arr2 elements right after arr1
        for (int i = 0; i < size2; i++) {
            nums[size1 + i] = arr2[i];
        }
        
        return nums;
    }
}
