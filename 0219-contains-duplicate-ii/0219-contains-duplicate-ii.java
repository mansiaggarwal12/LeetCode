class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        HashSet<Integer> set = new HashSet<>();
        while(n>right){
            while(right-left>k){
                set.remove(nums[left]);
                left++;
            }
            if(set.contains(nums[right]))return true;
            set.add(nums[right]);
            right++;
        }
        return false;
    }
}