package hard;

public class sudoko_solver {
     public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean isValid(char[][] board,int row,int col,char c ){
        for(int i =0;i<9;i++){
            if(board[row][i]==c)//check in the row
            return false;
            if(board[i][col]==c)//check in the column
            return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) //check in the 3x3 grid
            return false;
        }
    return true;
    }
    public boolean helper(char[][] board){
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')//check if it's empty
                {
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(helper(board)==true)
                            return true;
                            else //it means that we could not fill the next empty location so remove the value which we previoudly filled in the board
                            board[i][j]='.';
                        }
                    }
                    return false; // not able to fill from 1-9 in the given position
                }
            }
        }
        return true; // everything is filled up no empty spaces left
    }
    public static void main(String[] args) {
        sudoko_solver s = new sudoko_solver();
        char[][] board = {
           {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                    {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                    {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                    {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                    {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                    {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                    {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                    {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                    {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        s.solveSudoku(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
