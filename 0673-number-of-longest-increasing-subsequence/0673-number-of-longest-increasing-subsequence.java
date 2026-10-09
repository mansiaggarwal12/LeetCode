class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int [] length = new int[n];
        int [] count = new int[n];
        Arrays.fill(length,1);
        Arrays.fill(count,1);
        int maxLen = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(length[j]+1>length[i]){
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    else if(length[j]+1==length[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,length[i]);
        }
        int total = 0;
        for(int i=0;i<n;i++){
            if(length[i]==maxLen)total+=count[i];
        }
        return total;
    }
}