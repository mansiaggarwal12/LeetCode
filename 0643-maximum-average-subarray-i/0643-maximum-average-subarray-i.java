class Solution {
    public double findMaxAverage(int[] nums, int k) {
       if(nums.length<k)return -1;
       double avg = 0;
       for(int i=0;i<k;i++){
        avg+=nums[i];
       }
       double maxAvg = avg;
       for(int i=k;i<nums.length;i++){
        avg += nums[i];
        avg -= nums[i-k];
        maxAvg = Math.max(avg,maxAvg);
       }
       return maxAvg/k;
    }
}