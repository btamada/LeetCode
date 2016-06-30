/**

 Write a sqrt() method without using the in-built method

 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

    private static boolean isPerfectSquare(int num) {
        if(num <= 0) return false;
        long r = num;
        while (r*r > num)
            r = (r + num/r) / 2;
        return r*r == num;
    }

}
