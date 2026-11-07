class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [] prev = new int[n];
        for(int j=0;j<n;j++){
            prev[j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            int [] curr = new int[n];
            for(int j=0;j<n;j++){
                int up=prev[j];
                int left = Integer.MAX_VALUE;
                if(j>0)left=prev[j-1];
                int right = Integer.MAX_VALUE;
                if(j<n-1)right = prev[j+1];
                curr[j] = matrix[i][j]+Math.min(up,Math.min(left,right));
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans = Math.min(ans,prev[j]);
        }
        return ans;
    }
}