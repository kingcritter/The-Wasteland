// Selection Sort

import java.util.*;
import java.util.ArrayList;

// returns a sorted list of integers
// Oh god this is probably a terrible way to make it accept different 
// types. Honestly I didn't even think this would work, which is a sign
// that I really need to read more about Classes and shit. Also, this
// givves a compiler warning.
class SelectionSort {
    public static ArrayList<Comparable> sort(ArrayList<Comparable> list) {
        ArrayList<Comparable> unsorted = new ArrayList<Comparable>(list);
        ArrayList<Comparable> sorted = new ArrayList<Comparable>();
        while (!unsorted.isEmpty()) {
            Comparable min = unsorted.get(0);
            int minPos = 0;
            for (int i = 0; i < unsorted.size(); i++) {
                if (unsorted.get(i).compareTo(min) == -1) {
                    min = unsorted.get(i);
                    minPos = i;
                }
            }
            sorted.add(min);
            unsorted.remove(minPos);
        }
        return sorted;
    }

    // test this sucker
    public static void main(String[] args) {
        ArrayList<Comparable> list = new ArrayList<Comparable>();
        list.add(2);
        list.add(-1);
        list.add(-6);
        list.add(7);
        list.add(11);
        list = sort(list);
        for (Object x : list) { 
            System.out.println(x);
        }
    }
}
