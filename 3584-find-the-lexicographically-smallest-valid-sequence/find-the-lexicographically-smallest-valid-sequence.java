class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = last position in word1
        // where word2[j] can be matched
        int[] last = new int[m];

        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        int i = n - 1;
        int j = m - 1;

        // Build last[]
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // Now greedily build answer
        boolean canChange = true;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use our one allowed mismatch
            else if (canChange &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                canChange = false;
            }

            i++;
        }

        // Couldn't find enough indices
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}