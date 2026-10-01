class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int maxVal = 0;
        for(int num:nums){
            maxVal = Math.max(maxVal,num);
        }
        int []earn = new int[maxVal+1];
        for(int num:nums){
            earn[num] += num;
        }
        int prev2 = 0, prev1 = earn[1];
        for(int val = 2; val<=maxVal; val++){
            int take = earn[val] + prev2;
            int skip = prev1;
            int curr = Math.max(take,skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}