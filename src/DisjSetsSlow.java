// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-11 22:28
 */
public class DisjSetsSlow {

    private int[] s;

    /**
     * Construct the disjoint sets object.
     *
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSetsSlow(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    // Test main; all finds on same output line should be identical
    public static void main(String[] args) {
        int numElements = 128;
        int numInSameSet = 16;

        DisjSetsSlow ds = new DisjSetsSlow(numElements);
        int set1, set2;

        for (int k = 1; k < numInSameSet; k *= 2) {
            for (int j = 0; j + k < numElements; j += 2 * k) {
                set1 = ds.find(j);
                set2 = ds.find(j + k);
                ds.union(set1, set2);
            }
        }

        for (int i = 0; i < numElements; i++) {
            System.out.print(ds.find(i) + "*");
            if (i % numInSameSet == numInSameSet - 1)
                System.out.println();
        }
        System.out.println();
    }

    /**
     * Union two disjoint sets.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     *
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union(int root1, int root2) {
        s[root2] = root1;
    }

    /**
     * Perform a find.
     * Error checks omitted again for simplicity.
     *
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find(int x) {
        if (s[x] < 0) {
            return x;
        } else {
            return find(s[x]);
        }
    }
}