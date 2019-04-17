// Exercise the IntCell class

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-17 22:14
 */
public class TestIntCell {
    public static void main(String[] args) {
        IntCell m = new IntCell();

        m.write(5);
        System.out.println("Cell contents: " + m.read());
        // The next line would be illegal if uncommented
        //  m.storedValue = 0;
    }
}
