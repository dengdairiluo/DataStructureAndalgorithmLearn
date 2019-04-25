/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-25 22:10
 */
public class MyBaseHashTable<AnyType> {

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     *
     * @param n the number to test.
     * @return the result of the test.
     */
    protected static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Internal method to find a prime number at least as large as n.
     *
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    protected static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }

        while (!isPrime(n)) {
            n += 2;
        }

        return n;
    }
}
