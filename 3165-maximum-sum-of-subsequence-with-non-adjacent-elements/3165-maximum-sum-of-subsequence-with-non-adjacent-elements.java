
import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final long NEG = Long.MIN_VALUE;

    private long[][][] tree;
    private int[] nums;

    private long[][] combine(long[][] left, long[][] right) {
        long[][] parent = new long[2][2];

        for (long[] row : parent) {
            Arrays.fill(row, NEG);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        if (a == 1 && b == 1) continue;

                        if (left[i][a] == NEG || right[b][j] == NEG) {
                            continue;
                        }

                        long sum = left[i][a] + right[b][j];
                        parent[i][j] = Math.max(parent[i][j], sum);
                    }
                }
            }
        }

        return parent;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node][0][0] = 0;
            tree[node][1][1] = nums[start];
            tree[node][0][1] = NEG;
            tree[node][1][0] = NEG;
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = combine(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node][0][0] = 0;
            tree[node][1][1] = val;
            tree[node][0][1] = NEG;
            tree[node][1][0] = NEG;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }

        tree[node] = combine(tree[2 * node], tree[2 * node + 1]);
    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        this.nums = nums;

        int n = nums.length;
        tree = new long[4 * n][2][2];

        build(1, 0, n - 1);

        long ans = 0;

        for (int[] q : queries) {
            update(1, 0, n - 1, q[0], q[1]);

            long best = 0;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    best = Math.max(best, tree[1][i][j]);
                }
            }

            ans = (ans + best) % MOD;
        }

        return (int) ans;
    }
}
