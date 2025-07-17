package hard;
public class word_search {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n = board[0].length;
        int index=0;
        //find the first character of the word in the board
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==word.charAt(index)){
                if(searchNext(board,word,i,j,index,m,n))
                return true;
                }
            }
        }
        return false;
    }
    static boolean searchNext(char board[][],String word,int row,int col,int index,int m,int n){
        if(index==word.length())
        return true;
        // Check if the current position is out of bounds or if the character does not match or if it has already been visited
        if(row<0||col<0||row==m||col==n||board[row][col]!=word.charAt(index)||board[row][col]=='!')
        return false;

        char c = board[row][col];
        board[row][col]='!';// Mark the cell as visited

        // Explore all four directions: left, right, up, down
        // If any of the directions return true, we have found the word
        boolean left = searchNext(board,word,row,col-1,index+1,m,n);
        boolean right = searchNext(board,word,row,col+1,index+1,m,n);
        boolean up = searchNext(board,word,row-1,col,index+1,m,n);
        boolean down = searchNext(board,word,row+1,col,index+1,m,n);

        board[row][col]=c;// Unmark the cell after exploring
        return left||right||up||down;
    }
    public static void main(String[] args) {
        word_search ws = new word_search();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result = ws.exist(board, word);
        System.out.println("Does the word exist in the board? " + result);
    }
}
