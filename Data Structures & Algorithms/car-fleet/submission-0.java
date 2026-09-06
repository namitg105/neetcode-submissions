class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair up position and speed for each car
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Calculate time to reach target as a floating point value
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by starting position in ascending order
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleetCount = 0;
        double maxTime = 0; // Represents the arrival time of the fleet directly ahead

        // Process cars from closest to target (backwards from the sorted array)
        for (int i = n - 1; i >= 0; i--) {
            double currentTime = cars[i][1];

            // If the trailing car's time is greater than the current fleet's time,
            // it can never catch up. It forms a new fleet and becomes the new leader.
            if (currentTime > maxTime) {
                fleetCount++;
                maxTime = currentTime;
            }
            // Otherwise (currentTime <= maxTime), it catches up and merges into maxTime's fleet.
        }

        return fleetCount;
    }
}