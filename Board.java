import java.util.*;

public class Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[] source = {scanner.nextInt(), scanner.nextInt()};
        int[] destination = {scanner.nextInt(), scanner.nextInt()};
        int[] moveRule = {scanner.nextInt(), scanner.nextInt()};
        int result = minMovesToReachDestination(grid, source, destination, moveRule);
        System.out.println(result);
        
        scanner.close();
    }

    private static int minMovesToReachDestination(int[][] grid, int[] source, int[] destination, int[] moveRule) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.offer(new int[]{source[0], source[1], 0}); 
        visited[source[0]][source[1]] = true;
        int[][] directions = {
            {moveRule[0], moveRule[1]},       
            {moveRule[1], -moveRule[0]},     
            {-moveRule[0], -moveRule[1]},     
            {-moveRule[1], moveRule[0]}       
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            if (x == destination[0] && y == destination[1]) {
                return steps;
            }
            for (int dir = 0; dir < 4; dir++) {
                int newX = x + directions[dir][0];
                int newY = y + directions[dir][1];
                if (newX >= 0 && newX < M && newY >= 0 && newY < N && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, steps + 1});
                }
            }
        }
      return -1;
    }
}