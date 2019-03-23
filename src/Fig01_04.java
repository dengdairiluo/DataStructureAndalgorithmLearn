/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-23 23:38
 */
public class Fig01_04 {

    public static void printDigit(int n) {
        System.out.print(n);
    }

    public static void printOut(int n) {
        if (n >= 10) {
            printDigit(n / 10);
        }
        printDigit(n % 10);
    }

    public static void main(String[] args) {
        printOut(1369);
        System.out.println();
    }
}
