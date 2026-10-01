class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int currMax = nums[0], currMin = nums[0], maxSoFar = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(nums[i],nums[i]*currMax);
            currMin = Math.min(nums[i],nums[i]*currMin);
            maxSoFar = Math.max(maxSoFar,currMax);
        }
        return maxSoFar;
    }
}