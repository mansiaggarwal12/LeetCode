class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0; // Minimum possible open left brackets
        int leftMax = 0; // Maximum possible open left brackets

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else { 
                // c == '*'
                leftMin--; // Treat '*' as ')'
                leftMax++; // Treat '*' as '('
            }

            // If leftMax is negative, there are more ')' than '(' and '*' combined.
            if (leftMax < 0) {
                return false;
            }

            // leftMin cannot be negative. If it drops below 0, it means we treated 
            // a '*' as a ')' when we actually shouldn't have (or treated it as empty).
            // So, reset it to 0 (treat it as empty string instead).
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        // If leftMin is 0, it means we can perfectly balance all open parentheses.
        return leftMin == 0;
    }
}