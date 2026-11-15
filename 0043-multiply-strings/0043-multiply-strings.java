class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int [] result = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int digit1=num1.charAt(i)-'0';
                int digit2=num2.charAt(j)-'0';
                int product=digit1*digit2;
                int pos1=i+j;
                int pos2=i+j+1;
                result[pos2]+=product;
                result[pos1]+=result[pos2]/10;
                result[pos2]%=10;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (result[i] == 0)i++;
        for (; i < result.length; i++) {
            res.append(result[i]);
        }
        return res.toString();
    }
}