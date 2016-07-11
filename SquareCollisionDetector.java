/**

 Determine if 2 squares overlap each other given their (x,y) points on a graph

 */
public class SquareCollisionDetector {

    public static void main(String[] args) {
        System.out.println(collisionDetected(20,20,0,0,3));
    }

    private static boolean collisionDetected(int x1, int y1, int x2, int y2, int side) {
        return (Math.abs(x1 - x2) < side && Math.abs(y1 - y2) < side);
    }

}
