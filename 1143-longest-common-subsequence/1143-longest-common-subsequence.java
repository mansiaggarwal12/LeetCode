class Solution {
    public int longestCommonSubsequence(String a, String b) {
        if(b.length()>a.length()){
            String t = b;
            b = a;
            a = t;
        }
        int n = a.length();
        int m = b.length();
        int [] prev = new int [m+1];
        int [] curr = new int [n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}