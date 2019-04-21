import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-21 23:38
 */
public class RemoveEvens {

    public static void removeEvensVer1(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0) {
                lst.remove(i);
            } else {
                i++;
            }
        }
    }

    public static void removeEvensVer2(List<Integer> lst) {
        for (Integer x : lst) {
            if (x % 2 == 0) {
                lst.remove(x);
            }
        }
    }

    public static void removeEvensVer3(List<Integer> lst) {

        lst.removeIf(integer -> integer % 2 == 0);
    }

    public static void main(String[] args) {
        int n = 1600000;
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            lst1.add(i);
            lst2.add(i);
        }

        long start, end;

        start = System.currentTimeMillis();
        removeEvensVer3(lst2);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms for LinkedList size " + n);

        start = System.currentTimeMillis();
        removeEvensVer3(lst1);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms for ArrayList size " + n);

    }
}
