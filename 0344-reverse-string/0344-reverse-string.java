class Solution {
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
    void rev(char[]s,int b, int e){
        if(b>=e)return;
        char temp = s[b];
        s[b] = s[e];
        s[e] = temp;
        rev(s,b+1,e-1);
    }
}