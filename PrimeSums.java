import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * It is possible to write ten as the sum of primes in exactly five different ways:

 7 + 3
 5 + 5
 5 + 3 + 2
 3 + 3 + 2 + 2
 2 + 2 + 2 + 2 + 2

 What is the first value which can be written as the sum of primes in over five thousand different ways?
 */

public class PrimeSums {

    public static void main(String[] args) {
        System.out.println(primeSum(5000));
    }

    static int primeSum(int limit) {
        // find the number of primes we need
        List<Integer> myListPrimes = findPrimes(100);
        int size = 100;
        int result = 0;
        int[] tmp = new int[size + 1];
        tmp[0] = 1;

        for(Integer p : myListPrimes) {
            for(int i = 0; i + p <= size; i++) {
                System.out.print("Index i: " + i + " ");
                System.out.println("tmp[i] " + tmp[i]);
                tmp[i + p] += tmp[i];
                System.out.print("Index i+p: " + (i+p) + " ");
                System.out.println("tmp[i + p] " + tmp[i + p]);
            }
        }

        for(int j = 0; j < size; j++) {
            if(tmp[j] > limit) {
                result = j;
                break;
            }
        }

        return result;

    }

    // Sieve of Eratosthenes formula for finding all primes of a number n
    private static List<Integer> findPrimes(int num) {
        List<Integer> listPrimes = new LinkedList<>();
        boolean[] primes = new boolean[num+1];

        for(int a = 0; a < primes.length; a++) {
            primes[a] = true;
        }

        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i * i <= num; i++) {
            if(primes[i]) {
                for(int j = i * i; j <= num; j += i) {
                    primes[j] = false;
                }
            }
        }

        for(int k = 1; k < num; k++) {
            if(primes[k]) listPrimes.add(k);
        }

        return listPrimes;
    }

}

