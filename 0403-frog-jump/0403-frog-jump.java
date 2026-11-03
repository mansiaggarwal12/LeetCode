class Solution {
    public boolean canCross(int[] stones) {

        if (stones.length == 1) return true;
        if (stones[1] != 1) return false;

        int n = stones.length;

        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            set.add(stones[i]);
            indexMap.put(stones[i], i);
        }

        boolean[][] dp = new boolean[n][n + 1];

        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= n; k++) {

                if (!dp[i][k]) continue;

                for (int jump = k - 1; jump <= k + 1; jump++) {

                    if (jump <= 0) continue;

                    int nextPosition = stones[i] + jump;

                    if (set.contains(nextPosition)) {
                        int nextIndex = indexMap.get(nextPosition);
                        dp[nextIndex][jump] = true;
                    }
                }
            }
        }

     
        for (int j = 0; j <= n; j++) {
            if (dp[n - 1][j]) return true;
        }

        return false;
    }
}