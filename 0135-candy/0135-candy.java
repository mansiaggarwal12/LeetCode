class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int up = 0, down = 0, peak = 0, candy = 1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                up++;
                down=0;
                peak=up;
                candy+=up+1;
            }
            else if(ratings[i]==ratings[i-1]){
                up=0;
                down=0;
                peak=0;
                candy+=1;
            }
            else{
                down++;
                up=0;
                candy+=down;
                if(down>peak)candy+=1;
            }
        }
        return candy;
    }
}