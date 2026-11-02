class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [] dr = {-1,-1,-1,0,0,1,1,1};
        int [] dc = {-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int liveNeighbours=0;
                for(int k=0;k<8;k++){
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<m){
                        if(board[nr][nc]==1||board[nr][nc]==-1)liveNeighbours++;
                    }
                }
                if(board[i][j]==1 && liveNeighbours<2)board[i][j]=-1;
                if(board[i][j]==1 && liveNeighbours>3)board[i][j]=-1;
                if(board[i][j]==0 && liveNeighbours==3)board[i][j]=2;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==-1)board[i][j]=0;
                if(board[i][j]==2)board[i][j]=1;
            }
        }
    }
}