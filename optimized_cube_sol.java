import java.util.Scanner;
public class optimized_cube_sol {

    private static final double ARC_RADIUS = 10 / Math.sqrt(2);  // Half the diagonal of a face
    private static final double ARC_ANGLE = Math.PI / 3;  // 60 degrees in radians
    private static final double ARC_DISTANCE = ARC_RADIUS * ARC_ANGLE;  // Precomputed arc distance for 60 degrees

    // Calculate Manhattan distance on different faces
    public static double shortestDistanceOnCube(double[] p1, double[] p2) {
        double dx = Math.abs(p2[0] - p1[0]);
        double dy = Math.abs(p2[1] - p1[1]);
        double dz = Math.abs(p2[2] - p1[2]);
        return dx + dy + dz;
    }

    // Calculate total travel distance
    public static double totalTravelDistance(double[][] points, int N) {
        double totalDistance = 0.0;

        for (int i = 0; i < N - 1; i++) {
            double[] p1 = points[i];
            double[] p2 = points[i + 1];

            if (p1[2] == p2[2]) {  // Same face (same z value)
                totalDistance += ARC_DISTANCE;
            } else {  // Different faces
                totalDistance += shortestDistanceOnCube(p1, p2);
            }
        }

        return Math.round(totalDistance * 100.0) / 100.0;  // Round to two decimal places
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of points
        int N = scanner.nextInt();
        
        // Create an array to hold the points
        double[][] points = new double[N][3];

        // Fill the points array by directly reading the input
        for (int i = 0; i < N; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
            points[i][2] = scanner.nextDouble();
        }

        // Calculate total travel distance
        double totalDistance = totalTravelDistance(points, N);

        // Print result, ensuring two decimal places
        System.out.printf("%.2f%n", totalDistance);

        scanner.close();
    }
}
