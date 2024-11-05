import java.util.*;
public class PlaceFinder {
        static class Device {
            int id;
            List<Connection> connections;
    
            Device(int id) {
                this.id = id;
                this.connections = new ArrayList<>();
            }
        }
    
        static class Connection {
            int deviceId;
            double dist;
            double a; 
            Connection(int deviceId, double dist, double a) {
                this.deviceId = deviceId;
                this.dist = dist;
                this.a = a;
            }
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            Map<Integer, Device> devices = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] parts = sc.nextLine().split(":");
                int deviceId = Integer.parseInt(parts[0]);
                int numConnections = Integer.parseInt(parts[1]);
                devices.put(deviceId, new Device(deviceId));
    
                for (int j = 0; j < numConnections; j++) {
                    String[] connectionData = sc.nextLine().split(" ");
                    int connectedDeviceId = Integer.parseInt(connectionData[0]);
                    double dist = Double.parseDouble(connectionData[1]);
                    double a = Double.parseDouble(connectionData[2]);
                    devices.get(deviceId).connections.add(new Connection(connectedDeviceId, dist, a));
                }
            }
            int deviceAId = sc.nextInt();
            int deviceBId = sc.nextInt();
    
            Map<Integer, double[]> positions = new HashMap<>();
            positions.put(deviceAId, new double[]{0.0, 0.0});
            calculatePositions(devices, positions, deviceAId);
            double[] posA = positions.get(deviceAId);
            double[] posB = positions.get(deviceBId);
            double distance = Math.sqrt(Math.pow(posB[0] - posA[0], 2) + Math.pow(posB[1] - posA[1], 2));
            System.out.printf("%.2f\n", distance);
            sc.close();
        }
    
        private static void calculatePositions(Map<Integer, Device> devices, Map<Integer, double[]> positions, int deviceId) {
            Device device = devices.get(deviceId);
            for (Connection conn : device.connections) {
                if (!positions.containsKey(conn.deviceId)) {
                    double[] pos = positions.get(deviceId);
                    double angleRad = Math.toRadians(conn.a);
                    double newX = pos[0] + conn.dist * Math.cos(angleRad);
                    double newY = pos[1] + conn.dist * Math.sin(angleRad);
                    positions.put(conn.deviceId, new double[]{newX, newY});
                    calculatePositions(devices, positions, conn.deviceId);
                }
            }
        }
    }

