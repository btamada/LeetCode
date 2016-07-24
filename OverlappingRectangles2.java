/**
 * Determine if 2 rectangles are overlapping
 */
public class OverlappingRectangles2 {

    public static void main(String[] args) {
        Point p1 = new Point(0, 5, 5, 0);
        Point p2 = new Point(-1, 0, -4, 6);
        System.out.println(isOverlapping(p1,p2));
    }

    private static class Point {
        int x1;
        int x2;
        int y1;
        int y2;

        Point(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    private static boolean isOverlapping(Point p1, Point p2) {
        if(p1 == null || p2 == null) return false;
        if(p2.x1 < p1.x1 || p2.x2 > p1.x2 || p2.y1 > p1.y1 || p2.y2 < p1.y2) return false;
        return true;
    }

}
