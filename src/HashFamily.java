/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-30 23:43
 */
public interface HashFamily<AnyType> {

    int hash(AnyType x, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}
