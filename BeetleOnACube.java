import java.util.Scanner;

public class BeetleOnACube {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double distance = 0.0;
        double[] currentPoint = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };
        for (int i = 1; i < n; i++) {
            double[] nextPoint = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };
            double legDistance;
            if (currentPoint[2] == nextPoint[2]) { // same face
                legDistance = arcDistance(currentPoint, nextPoint);
            } else { // different face
                legDistance = straightDistance(currentPoint, nextPoint);
            }
            distance += legDistance;
            currentPoint = nextPoint;
        }
        System.out.printf("%.2f", distance);
        sc.close();
    }

    private static double arcDistance(double[] point1, double[] point2) {
        double distance = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
        return Math.round(distance * Math.PI / 3 * 100) / 100.0;
    }

    private static double straightDistance(double[] point1, double[] point2) {
        double xDistance = Math.abs(point1[0] - point2[0]);
        double yDistance = Math.abs(point1[1] - point2[1]);
        double zDistance = Math.abs(point1[2] - point2[2]);
        double totalDistance = xDistance + yDistance + zDistance;
        if (point1[0] == point2[0] || point1[1] == point2[1]) { // same column or row
            return Math.round(totalDistance * 100) / 100.0;
        } else { // diagonal
            return Math.round((totalDistance - 2) * 100) / 100.0;
        }
    }
}