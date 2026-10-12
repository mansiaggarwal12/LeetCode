class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)sum+=x;
        if(sum%2!=0)return false;
        return subsetSumSpace(nums,sum/2);
    }
    private boolean subsetSumSpace(int []nums, int target){
        boolean [] dp = new boolean[target+1];
        dp[0] = true;
        for(int n:nums){
            for(int j=target;j>=n;j--){
                dp[j] = dp[j] || dp[j-n];
            }
        }
        return dp[target];
    }
}