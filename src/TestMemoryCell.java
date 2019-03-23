/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-23 23:45
 */
public class TestMemoryCell {
    public static void main(String[] args) {
        MemoryCell<Integer> m = new MemoryCell<>();
        m.write(5);
        System.out.println("Contents are: " + m.read());

    }
}
