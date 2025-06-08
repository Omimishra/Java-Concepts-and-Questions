package stack;

public class celebrity_problem {
    public int celebrity(int mat[][]){
        int n = mat.length;
        int top = 0;
        int down = n-1;
        while(top < down){
            if(mat[top][down] == 1){
                // top knows down, so top cannot be a celebrity
                top++;
            } 
            else if(mat[top][down] == 1){
                // top does not know down, so down cannot be a celebrity
                down--;
            }
            else {
                // top does not know down, so down cannot be a celebrity
                top++;
                down--;
            }
        }
        if(top>down) return -1; // no celebrity found
        for(int i=0; i<n; i++){
            if(top == i) continue; // skip the top person
            if(mat[top][i] == 1 || mat[i][top] == 0){
                return -1; // top is not a celebrity
            }
        }
        return top; // top is a celebrity
    }
    public static void main(String[] args) {
        celebrity_problem obj = new celebrity_problem();
        int[][] mat = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 1, 0}
        };
        int result = obj.celebrity(mat);
        System.out.println(result); // Output: 1 (the index of the celebrity)
    }
}
