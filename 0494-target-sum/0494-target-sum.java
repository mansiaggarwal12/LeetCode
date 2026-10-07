class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }
        int k = (target+sum)/2;
        int [] dp = new int[k+1];
        dp[0] = 1;
        for(int i:nums){
            for(int w=k;w>=i;w--){
                dp[w] += dp[w-i];
            }
        }
        return dp[k];
    }
}