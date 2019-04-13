import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-03-24 22:09
 */
public class Fig02_09 {

    public static final int NOT_FOUND = -1;

    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch(AnyType[] a, AnyType x) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            // 改动理由： 防越界
            int mid = low + (high - low) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;

            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }

    public static void main( String [ ] args )
    {
        int SIZE = 8;
        Integer [ ] a = new Integer [ SIZE ];
        for( int i = 0; i < SIZE; i++ ) {
            a[ i ] = i * 2;
        }

        for( int i = 0; i < SIZE * 2; i++ ) {
            System.out.println( "Found " + i + " at " + binarySearch( a, i ) );
        }
    }
}
