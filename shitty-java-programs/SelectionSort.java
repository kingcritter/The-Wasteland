// Selection Sort

import java.util.*;
import java.util.ArrayList;

// returns a sorted list of integers
// todo: make it type agnostic
class SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        ArrayList<Integer> unsorted = new ArrayList<Integer>(list);
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        while (!unsorted.isEmpty()) {
            int min = unsorted.get(0);
            int minPos = 0;
            for (int i = 0; i < unsorted.size(); i++) {
                if (unsorted.get(i) < min) {
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(-1);
        list.add(-6);
        list.add(7);
        list.add(11);
        list = sort(list);
        for (int x : list) { 
            System.out.println(x);
        }
    }
}