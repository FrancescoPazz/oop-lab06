package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> list = new ArrayList<Integer>();
        for (Integer index = 1000; index < 2000; index++) {
            list.add(index);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> list2 = new LinkedList<Integer>(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmpFirst = list.get(1);
        list.set(list.size() - 1, tmpFirst);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.println("Content of arraylist: ");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        int COUNTER = 100000;
        long time = System.nanoTime();
        for (int i = 0; i < COUNTER; i++) {
            list.add(i);
            list2.add(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Le performance dell'inserimento è: " + millis);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        COUNTER = 1000;        
        time = System.nanoTime();
        for (int i = 0; i < COUNTER; i++) {
            list.get(list.size()/2);
            list2.get(list2.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Le performance della lettura è: " + millis);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("Africa", (double) 1110635000);
        map.put("Americas", (double)972005000);
        map.put("Antarctica", (double)0);
        map.put("Asia", Double.parseDouble("4298723000"));
        map.put("Europe", (double)742452000);
        map.put("Antarctica", (double)38304000);
        /*
         * 8) Compute the population of the world
         */
        for (Map.Entry<String, Double> country : map.entrySet()) { 
  
            System.out.print(country.getKey() + ":"); 
            System.out.println(country.getValue()); 
        } 
    }
}
