class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // int candy = n;
        // for(int i=0;i<n;i++){
        //     if(i==0 && ratings[0]>ratings[1])candy++;
        //     else if(i==n-1 && ratings[n-1]>ratings[n-2])candy++;
        //     else if(ratings[i]>ratings[i-1]||ratings[i]>ratings[i+1])candy++;
        // }
        // return candy;
        int [] candy = new int[n];
        for(int i=0;i<n;i++){
            candy[i] = 1;
        }
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])candy[i]=candy[i-1]+1;
        }
        int sum = candy[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])candy[i]=Math.max(candy[i],candy[i+1]+1);
            sum+=candy[i];
        }
        return sum;
    }
}