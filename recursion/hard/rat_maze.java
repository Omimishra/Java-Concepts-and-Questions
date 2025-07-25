package hard;

import java.util.ArrayList;
// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.
public class rat_maze {
    public static ArrayList < String > findPath(int[][] m, int n) {
        int vis[][]= new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                vis[i][j] = 0;
            }
        }
        ArrayList < String > ans = new ArrayList < > ();
        if(m[0][0]==1)
        solve(0,0,m,n,vis,"",ans);
        return ans;
    }
    private static void solve(int i,int j,int [][]m,int n,int vis[][],String move,ArrayList<String> ans){
        if(i==n-1&&j==n-1){
            ans.add(move);
            return;
        }
        // down
        if(i+1<n && vis[i+1][j]==0 && m[i+1][j]==1){
            vis[i][j]=1;
            solve(i+1,j,m,n,vis,move+"D",ans);
            vis[i][j]=0; // backtrack
        }
        // up
        if(i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1){
             vis[i][j]=1;
            solve(i-1,j,m,n,vis,move+"U",ans);
            vis[i][j]=0; // backtrack
        }
        // right
        if(j+1<n && vis[i][j+1]==0 && m[i][j+1]==1){
             vis[i][j]=1;
            solve(i,j+1,m,n,vis,move+"R",ans);
            vis[i][j]=0; // backtrack
        }
        // left
        if(j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1){
             vis[i][j]=1;
            solve(i,j-1,m,n,vis,move+"L",ans);
            vis[i][j]=0; // backtrack
        }
    }
    public static void main(String[] args) {
        int[][] m = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {1, 1, 1, 1}
        };
        ArrayList<String> paths = findPath(m, m.length);
        System.out.println(paths);
    }
}
