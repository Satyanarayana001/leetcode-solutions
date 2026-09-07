class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007;

        long[] last = new long[26];

        long total = 1; // empty subsequence

        for (char c : s.toCharArray()) {
            int x = c - 'a';

            long newSubseq = total;

            total = (total + newSubseq - last[x] + MOD) % MOD;

            last[x] = newSubseq;
        }

        return (int)((total - 1 + MOD) % MOD);
    }
}