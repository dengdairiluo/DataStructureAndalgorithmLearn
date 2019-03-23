/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-23 23:44
 */
public class MemoryCell<AnyType> {
    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}
