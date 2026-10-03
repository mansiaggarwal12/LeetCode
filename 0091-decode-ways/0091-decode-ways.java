class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')return 0;
        int n = s.length();
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int single = s.charAt(i-1)-'0';
            if(single>=1 && single<=9)dp[i]+=dp[i-1];
            int doubleDigit = Integer.parseInt(s.substring(i-2,i));
            if(doubleDigit>=10 && doubleDigit<=26)dp[i]+=dp[i-2];
        }
        return dp[n];
    }

}