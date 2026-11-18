class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][]seenInRow = new boolean[9][9];
        boolean[][]seenInCol = new boolean[9][9];
        boolean[][]seenInBox = new boolean[9][9];
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];
                if(c=='.')continue;
                int val = c-'1';
                int boxIndex = (i/3)*3+(j/3);
                if(seenInRow[i][val]||seenInCol[j][val]||seenInBox[boxIndex][val])return false;
                seenInRow[i][val]=true;
                seenInCol[j][val]=true;
                seenInBox[boxIndex][val]=true;
            }
        }
        return true;
    }
}