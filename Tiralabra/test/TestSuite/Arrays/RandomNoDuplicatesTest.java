/*
 * Aks copyright from the author Marko <markoma@iki.fi>.
 * Creation date: 9.8.2014 
 */
package TestSuite.Arrays;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Marko <markoma@iki.fi>
 */
public class RandomNoDuplicatesTest {

    int[] rnd;

    public RandomNoDuplicatesTest() {
        rnd = new RandomNoDuplicates(1000).get();
    }

    /**
     * Test of get method for duplicates, of class RandomNoDuplicates.
     */
    @Test
    public void testNoDuplicates() {

        Set<Integer> lump = new HashSet<Integer>();
        for (int i = 0; i < rnd.length; i++) {
            assertFalse(lump.contains(rnd[i]));
            lump.add(rnd[i]);
        }
    }

    /**
     * Test of get method for containing integers 0..n, of class
     * RandomNoDuplicates.
     */
    @Test
    public void testContainsAll() {

        Set<Integer> lump = new HashSet<Integer>();
        for (int i = 0; i < rnd.length; i++) {
            lump.add(rnd[i]);
        }
        for (int j = 0; j < rnd.length; j++) {
            lump.remove(j);
        }
        assertTrue(lump.isEmpty());
    }

    /**
     * Test of get method for array size, of class RandomNoDuplicates.
     */
    @Test
    public void testSize() {
        assertTrue(rnd.length == 1000);
    }
}
