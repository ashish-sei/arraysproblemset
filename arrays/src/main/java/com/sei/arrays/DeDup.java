package com.sei.arrays;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
* <h1>DeDup</h1>
* The DeDup program implements 3 methods to remove duplicates
* from a given array of random integers.
*<p>
* @author  Ashish Yadav
* @version 1.0
* @since   2016-07-01
*/
public class DeDup {
	
    public int[] randomIntegers = {
            1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000,
            11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13,
            7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11,
            4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13,
            2, 11
        };

    /**
     * This is a naive solution to remove duplicates
     * from the given array of random ints.
     * 
     * <p>This implementation is pretty inefficient and yields to an
     * O(n2) complexity.
     * 
     * <p>This solution is also error prone due the use of flags and multiple loops.
     * <p>
     * @param randInts array of random ints
     * @return         array of unique ints
     */
    public int[] deDupNaive(int[] randInts) {
        int[] unique = new int[randInts.length];
        int count = 1;
        unique[0] = randInts[0];

        boolean dup = false;

        for (int i = 1; i < randInts.length; i++) {
            dup = false;

            for (int j = i - 1; j >= 0; j--) {
                if (randInts[i] == randInts[j]) {
                    dup = true;

                    break;
                }
            }

            if (!dup) {
                unique[count++] = randInts[i];
            }
        }

        return Arrays.copyOf(unique, count);
    }

    /**
     * This is Hashtable based solution to remove duplicates
     * from the given array of random ints.
     * 
     * <p>This solution is comparatively efficient than  deDupNaive(int []).
     * It is creating a hashtable with O(1) access.
     * 
     * <p>Using the single "for" loop and is easier to understand and maintain.
     * <p>
     * @param randInts array of random ints
     * @return         array of unique ints
     */
    public int[] deDupHashtable(int[] randInts) {
        int[] unique = new int[randInts.length];
        int count = 0;
        Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();

        for (int i : randInts) {
            if (!h.containsKey(i)) {
                h.put(i, i);
                unique[count] = i;
                count++;
            }
        }

        return Arrays.copyOf(unique, count);
    }

    /**
     * This is Set based solution to remove duplicates
     * from the given array of random ints.
     * 
     * <p>This solution is very efficient  Using the single "for"
     * loop and is very easy to understand and maintain.
     * 
     * <p>It is using internal java implementation of Set concept
     * for uniqueness.
     * 
     * <p>It also usages Integer objects instead of primitive int
     * <p>
     * @param randInts array of random ints
     * @return         array of unique Integers
     */
    public Integer[] deDupSet(int[] randInts) {
        Set<Integer> s = new LinkedHashSet<Integer>();

        for (int i : randInts) {
            s.add(i);
        }

        return s.toArray(new Integer[s.size()]);
    }
}