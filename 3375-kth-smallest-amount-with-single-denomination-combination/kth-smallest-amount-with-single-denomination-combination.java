class Solution {

    public long findKthSmallest(int[] coins, int k) {

        int minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long low = 1;
        long high = (long) minCoin * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(coins, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(int[] coins, long x) {

        int n = coins.length;
        long total = 0;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    lcm = (lcm / g) * coins[i];

                    // This subset contributes 0
                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (lcm > x) {
                continue;
            }

            if (bits % 2 == 1) {
                total += x / lcm;
            } else {
                total -= x / lcm;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}