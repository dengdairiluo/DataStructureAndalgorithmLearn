import java.util.HashSet;


// Cuckoo Hash table class
//
// CONSTRUCTION: a hashing function family and
//               an approximate initial size or default of 101
//
// ******************PUBLIC OPERATIONS*********************
// bool insert( x )       --> Insert x
// bool remove( x )       --> Remove x
// bool contains( x )     --> Return true if x is present
// void makeEmpty( )      --> Remove all items


/**
 * @author jianglub
 * @date 2019/4/2
 */
public class CuckooHashTableClassic<AnyType> extends MyBaseHashTable<AnyType> {
    private static final double MAX_LOAD = 0.49;
    private static final int ALLOWED_REHASHES = 100;
    private static final int DEFAULT_TABLE_SIZE = 101;
    private final HashFamily<? super AnyType> hashFunctions;
    private final int numHashFunctions;
    private int rehashes = 0;
    private AnyType[] array;
    private int currentSize;
    private int subTableSize;
    private int[] subTableStarts;
    /**
     * Construct the hash table.
     */
    public CuckooHashTableClassic(HashFamily<? super AnyType> hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public CuckooHashTableClassic(HashFamily<? super AnyType> hf, int size) {
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
        subTableSize = nextPrime(size / numHashFunctions);
        subTableStarts = new int[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            subTableStarts[i] = i * subTableSize;
        }
        allocateArray(subTableSize * numHashFunctions);
        doClear();
    }

    /**
     * Insert into the hash table. If the item is
     * already present, return false.
     *
     * @param x the item to insert.
     */
    public boolean insert(AnyType x) {
        final int COUNT_LIMIT = 100;
        if (contains(x)) {
            return false;
        }
        if (currentSize >= array.length * MAX_LOAD) {
            expand();
        }
        for (int i = 0, which = 0; i < COUNT_LIMIT; i++, which++) {
            if (which == numHashFunctions) {
                which = 0;
            }
            int pos = myhash(x, which);
            if (array[pos] == null) {
                array[pos] = x;
                currentSize++;
                return true;
            }

            AnyType tmp = array[pos];
            array[pos] = x;
            x = tmp;
        }

        if (rehashes++ >= ALLOWED_REHASHES) {
            expand();
            rehashes = 0;
        } else {
            rehash();
        }

        return insert(x);
    }

    protected int myhash(AnyType x, int which) {
        int hashVal = hashFunctions.hash(x, which);
        hashVal %= subTableSize;
        if (hashVal < 0) {
            hashVal += subTableSize;
        }
        return hashVal + subTableStarts[which];
    }

    private void expand() {
        rehash(numHashFunctions * nextPrime((int) (array.length / MAX_LOAD / numHashFunctions)));
    }

    private void rehash() {
        //System.out.println( "NEW HASH FUNCTIONS " + array.length );
        hashFunctions.generateNewFunctions( );
        rehash(array.length);
    }

    private void rehash(int newLength) {
     //   System.out.println( "REHASH: " + array.length + " " + newLength + " " + currentSize );
        
        AnyType [ ] oldArray = array;    // Create a new double-sized, empty table
        if (newLength != array.length) {
            subTableSize = newLength / numHashFunctions;
            for (int i = 0; i < numHashFunctions; i++) {
                subTableStarts[i] = i * subTableSize;
            }
        }
        allocateArray(newLength);
        currentSize = 0;
            // Copy table over
        for (AnyType str : oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    /**
     * Gets the size of the table.
     *
     * @return number of items in the hash table.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Gets the length (potential capacity) of the table.
     *
     * @return length of the internal array in the hash table.
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Method that searches two places.
     *
     * @param x the item to search for.
     * @return the position where the search terminates, or -1 if not found.
     */
    private int findPos(AnyType x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myhash(x, i);
            if (array[pos] != null && array[pos].equals(x)) {
                return pos;
            }
        }
        return -1;
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     * @return true if item was found and removed
     */
    public boolean remove(AnyType x) {
        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(AnyType x) {
        return findPos(x) != -1;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        doClear();
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of the array.
     */
    private void allocateArray(int arraySize) {
        array = (AnyType[]) new Object[arraySize];
    }
}

