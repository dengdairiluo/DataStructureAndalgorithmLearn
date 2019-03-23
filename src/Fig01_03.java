/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-23 23:35
 */
public class Fig01_03 {

    public static int bad(int n) {
        if (n == 0) {
            return 0;
        } else {
            return bad(n / 3 + 1) + n - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Bad is infinite recursion");
    }
}
