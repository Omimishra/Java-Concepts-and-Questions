package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nqueen {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';// Initialize the board with '.'
            }
        }
        helper(board, res, 0);// Start placing queens from the first column
         // Call the helper function to find all arrangements of N Queens on the board
         // The helper function will fill the res list with valid arrangements
        return res;
    }
    public static boolean isSafe(int row, int col, char[][] board) {
       //horizontal
       for(int j=0; j<board.length; j++) {
           if(board[row][j] == 'Q') {
               return false;
           }
       }
      
       //vertical
       for(int i=0; i<board.length; i++) {
           if(board[i][col] == 'Q') {
               return false;
           }
       }
      
       //upper left
       int r = row;
       for(int c=col; c>=0 && r>=0; c--, r--) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //upper right
       r = row;
       for(int c=col; c<board.length && r>=0; r--, c++) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //lower left
       r = row;
       for(int c=col; c>=0 && r<board.length; r++, c--) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //lower right
       for(int c=col; c<board.length && r<board.length; c++, r++) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       return true;
   }
  
  static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();// Create a list to hold the board configuration
        // Convert each row of the board to a string and add it to the list
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
  
   public static void helper(char[][] board, List<List<String>> res, int col) {
       if(col == board.length) {
           res.add(construct(board));
           // We have placed all queens, so we add the board to the result
           return;
       }
      
       for(int row=0; row<board.length; row++) {
           if(isSafe(row, col, board)) {
               board[row][col] = 'Q';// Place the queen at (row, col)
               // Recur to place the rest of the queens
               helper(board, res, col+1);
               board[row][col] = '.';// Backtrack by removing the queen from (row, col)
           }
       }
   }
   public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
        
    }
   

}
