
import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[] temp = score.clone();
        Arrays.sort(temp);

        String[] ans = new String[n];

        for (int i = n - 1; i >= 0; i--) {
            int rank = n - i;

            for (int j = 0; j < n; j++) {
                if (score[j] == temp[i]) {
                    if (rank == 1) {
                        ans[j] = "Gold Medal";
                    } else if (rank == 2) {
                        ans[j] = "Silver Medal";
                    } else if (rank == 3) {
                        ans[j] = "Bronze Medal";
                    } else {
                        ans[j] = String.valueOf(rank);
                    }

                    break;
                }
            }
        }

        return ans;
    }
}