// LinkedList implementation of a StringBuilder-like class
// in progress

import java.lang.Math;

public class LString {
    class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public LString() {
    }

    public LString(String input) {
        for (int i = 0; i < input.length(); i++) {
            append(input.charAt(i));
        }
    }

    public int length() {
        return length;
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();
        Node curr = first;
        while  (curr != null) {
            output.append(curr.data);
            curr = curr.next;
        }
        return output.toString();
    }

    public int compareTo(LString otherLString) {
        if (this.equals(otherLString))
            return 0; 
        Node curr = first;
        Node currOther = otherLString.first;
        while (curr != null && currOther != null) {
            if (curr.data != currOther.data) //if characters are different...
                return curr.data - currOther.data; //return distance between chars 
            curr = curr.next;
            currOther = currOther.next;
        } // if there's no difference found befoe running out of characters:
        return this.length - otherLString.length(); // returns difference in lengths
    }



    @Override public boolean equals(Object other) {
        if ((other == null) || !(other instanceof LString))
            return false;
        LString otherLString = (LString)other;
        if (this.length != otherLString.length)
            return false;
        Node curr = first;
        Node otherCurr = otherLString.first;
        while (curr != null) {
            if (curr.data != otherCurr.data)
                return false;
            curr = curr.next;
            otherCurr = otherCurr.next;
        }
        return true;
    }

    public char charAt(int i) {
        if ((i > length-1) || (i < 0)) {
            throw new IndexOutOfBoundsException("" + i);
        }
        Node curr = first;
        for (int x=0; x < i; x++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void setCharAt(int i, char ch) {
        if ((i > length-1) || (i < 0)) {
            throw new IndexOutOfBoundsException("" + i);
        }
        Node curr = first;
        for (int x=0; x < i; x++) {
            curr = curr.next;
            }
        curr.data = ch;
    }

    public LString substring(int start, int end) {
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        if ((start == end) && (end == this.length))
            return new LString();
        Node curr = first;
        LString newList = new LString();
        for (int i = 0; i < end; i++) {
            if (i >= start)
                newList.append(curr.data);
            curr = curr.next;
        }
        return newList;
    }

    // todo: Replace of empty LString is not working
    public LString replace(int start, int end, LString newSub) {
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        if (newSub.length == 0 && this.length == 0)
            return new LString();
        if (newSub.length == 0)
            return this;
        if (this.length == 0) {
            LString newList = new LString();
            for (Node curr = newSub.first; curr != null; curr = curr.next) {
                System.out.println(curr.data);
                newList.append(curr.data);
            }
            this.first = newList.first;
            return this;
        }
        int count = 0;
        int subCount = 0;
        LString newList = new LString();
        while (count < this.length) {
            if ((count >= start) && (count < end)) {
                subCount = 0;
                while (subCount < newSub.length()) {
                    newList.append(newSub.charAt(subCount));
                    subCount++;
                }
                count = end;
            }
            else {
                newList.append(this.charAt(count));
                count++;
            }
        }
        return newList;
    }

    // used for the constructor; could be made public, but it's
    // not in the assignment, so...
    private void append(char data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        }
        else {
            last.next = new Node(data);
            last = last.next;
        }
        length++;

    }

    }