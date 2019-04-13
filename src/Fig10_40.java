/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-13 22:43
 */
public class Fig10_40 {

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("fib( 7 ) = " + fib(7));
        System.out.println("fibonacci( 7 ) = " + fibonacci(7));
    }
}
