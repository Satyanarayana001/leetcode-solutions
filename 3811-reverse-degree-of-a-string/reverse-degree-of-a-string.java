class Solution {
    public int reverseDegree(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            int normalPosition = arr[i] - 'a' + 1;
            int reversePosition = 27 - normalPosition;
            sum += reversePosition * (i + 1);
        }
        return sum;
    }
}