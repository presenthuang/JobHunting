package interviewQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class ClosestPoints {

    public static void main(String[] args) {
        Collection<myPoint> points = new ArrayList<myPoint>();
        myPoint origin = new myPoint(0, 0);
        points.add(new myPoint(1, 1, origin));
        points.add(new myPoint(1, 3, origin));
        points.add(new myPoint(-1, 1, origin));
        points.add(new myPoint(-1, 3, origin));
        points.add(new myPoint(1, -1, origin));
        points.add(new myPoint(3, -1, origin));
        points.add(new myPoint(-1, -1, origin));
        points.add(new myPoint(-1, 3, origin));
        points.add(new myPoint(2, 2, origin));

        Collection<myPoint> closestPoints = new ClosestPoints().getClosestPoints(points, 5);
        System.out.print(closestPoints);
    }

    public Collection<myPoint> getClosestPoints(Collection<myPoint> points, int k) {
        PriorityQueue<myPoint> queue = new PriorityQueue<myPoint>(k);

        for (myPoint point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else {
                if (queue.peek().compareTo(point) < 0) {
                    queue.poll();
                    queue.offer(point);
                }
            }
        }

        return queue;
    }

}

class myPoint implements Comparable<myPoint> {
    int x, y;
    double dist;

    public myPoint(int x, int y, myPoint originPoint) {
        this.x = x;
        this.y = y;
        this.dist = Math.hypot(x - originPoint.x, y - originPoint.y);
    }

    public myPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(myPoint that) {
        return Double.valueOf(that.dist).compareTo(dist);
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
