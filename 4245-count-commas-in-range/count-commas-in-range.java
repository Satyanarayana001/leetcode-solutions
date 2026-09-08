class Solution {
    public int countCommas(int n) {
        long start = 1000;
        int commas = 1;
        long count = 0;

        while (start <= n) {
            long end = start * 1000 - 1;
            long last = Math.min(n, end);

            count += (last - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return (int) count;
    }
}