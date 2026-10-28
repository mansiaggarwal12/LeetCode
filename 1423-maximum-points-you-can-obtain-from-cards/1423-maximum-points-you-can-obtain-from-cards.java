class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int i : cardPoints) {
            total += i;
        }
        int n = cardPoints.length;
        int winSize = n - k;
        int winSum = 0;
        
        // Calculate the sum of the initial window
        for (int i = 0; i < winSize; i++) {
            winSum += cardPoints[i];
        }
        
        int minWinSum = winSum;
        
        // Slide the window across the array to find the minimum window sum
        for (int i = winSize; i < n; i++) {
            winSum += cardPoints[i] - cardPoints[i - winSize];
            minWinSum = Math.min(minWinSum, winSum);
        }
        
        return total - minWinSum;
    }
}