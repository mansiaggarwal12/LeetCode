class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = 0, prev2 = 0;
        for(int i=2;i<=n;i++){
            int op1 = cost[i-1]+prev1;
            int op2 = cost[i-2]+prev2;
            int curr = Math.min(op1,op2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}