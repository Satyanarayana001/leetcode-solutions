class Solution {
    
    public long findKthSmallest(int[] coins, int k) {
        
        // Step 1: Find the smallest coin
        int minCoin = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        
        // Step 2: Binary search range
        long low = 1;
        long high = (long) minCoin * k;
        
        while (low < high) {
            
            long mid = low + (high - low) / 2;
            
            // Count valid amounts <= mid
            long count = countAmounts(coins, mid);
            
            if (count >= k) {
                // mid can be the answer
                high = mid;
            } else {
                // Need a larger number
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    
    // Counts how many valid amounts are <= x
    private long countAmounts(int[] coins, long x) {
        
        int n = coins.length;
        long count = 0;
        
        // Go through every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {
            
            long lcm = 1;
            int selectedCoins = 0;
            boolean valid = true;
            
            for (int i = 0; i < n; i++) {
                
                // Check if ith coin is present in this subset
                if ((mask & (1 << i)) != 0) {
                    
                    selectedCoins++;
                    
                    // Calculate LCM safely
                    long gcd = gcd(lcm, coins[i]);
                    lcm = (lcm / gcd) * coins[i];
                    
                    // If LCM becomes bigger than x,
                    // this subset contributes 0
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }
            
            if (!valid) {
                continue;
            }
            
            // Inclusion-Exclusion
            if (selectedCoins % 2 == 1) {
                count += x / lcm;
            } else {
                count -= x / lcm;
            }
        }
        
        return count;
    }
    
    
    // Find GCD using Euclidean algorithm
    private long gcd(long a, long b) {
        
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}