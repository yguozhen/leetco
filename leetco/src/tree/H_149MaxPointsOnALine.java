package tree;

public class H_149MaxPointsOnALine {
    //solution1
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }
        int solution = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // find max number of points that lie on same line, starting at points[i]
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = y + "/" + x; // key for HashMap
                map.merge(slope, 1, Integer::sum);
            }

            int linesMax = 0;
            for (int value : map.values()) {
                linesMax = Math.max(linesMax, value);
            }

            solution = Math.max(solution, 1 + linesMax + samePoint);
        }
        return solution;
    }

    private int generateGcd(int a, int b) { // Euclid's Greatest Common Divisor (GCD) Algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
