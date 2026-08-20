class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2; i<n; i++){
            int lastArr1 = arr1.get(arr1.size()-1);
            int lastArr2 = arr2.get(arr2.size()-1);
            if(lastArr1>lastArr2){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        return Stream.concat(arr1.stream(), arr2.stream())
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}