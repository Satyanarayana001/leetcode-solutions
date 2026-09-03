public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // Found the number
            } else if (res == 1) {
                left = mid + 1; // Number is higher
            } else {
                right = mid - 1; // Number is lower
            }
        }
        
        return -1;
    }
}
