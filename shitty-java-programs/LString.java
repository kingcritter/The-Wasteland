// Crispin Stichart
// May 22, 2015
// CS 145
// Assignment 2
// Linked List String Builder 
// Implements an LString object that stores chars in a linked list.


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

    // returns 0 if it equals otherLString; if the lengths are the same, 
    // it returns the lexographic distance between the first differing character;
    // if lengths are different, it returns difference between lengths 
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


    // checks to see if the contents of an LString is equal to this one
    @Override public boolean equals(Object other) {
        if ((other == null) || !(other instanceof LString))
            return false;
        // are the different lengths? 
        LString otherLString = (LString)other;
        if (this.length != otherLString.length)
            return false;
        // they're same length, so we iterate over both at once and compare
        Node curr = first;
        Node otherCurr = otherLString.first;
        while (curr != null) {
            if (curr.data != otherCurr.data)
                return false;
            curr = curr.next;
            otherCurr = otherCurr.next;
        }
        // The above didn't retrun false, so they must be equal. 
        return true;
    }

    // returns the character at index i.  
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

    //changes the value of the character at index i. 
    public void setCharAt(int i, char ch) {
        if ((i > length-1) || (i < 0)) {
            throw new IndexOutOfBoundsException("can't set char at: " + i);
        }
        Node curr = first;
        for (int x=0; x < i; x++) {
            curr = curr.next;
            }
        curr.data = ch;
    }

    // returns an LString object that's a subsection of the original, from
    // start up to end. 
    public LString substring(int start, int end) {
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        Node curr = first;
        LString newList = new LString();
        for (int i = 0; i < end; i++) {
            if (i >= start)
                newList.append(curr.data);
            curr = curr.next;
        }
        return newList;
    }

    // replaces a section of the LString, modifying it in place, and then 
    // returning a refference to the original LString. If start = end, it
    // inserts substitute at that point.
    public LString replace(int start, int end, LString substitute) {
        // checks to see if start and end are okay
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        // update length
        this.length = this.length + substitute.length - (end-start);
        // copy substitute data to new LString 
        LString tempList = new LString();
        for (Node currOther = substitute.first; currOther != null; currOther = currOther.next) {
            tempList.append(currOther.data);
        }
        // assign new node to start at:
        Node specialFront = new Node('!');
        specialFront.next = this.first;
        this.first = specialFront;
        // walk down list to start position
        Node curr = specialFront;
        for (int x = 0; x < start; x++) {
            curr = curr.next;
        }
        Node startOfReplace = curr;
        // walk down list to end position
        for (int x = 0; x <= end-start; x++) {
            curr = curr.next;
        }
        // relink list
        startOfReplace.next = tempList.first;
        tempList.last.next = curr;
        if (tempList.last.next == null)
            this.last = tempList.last;
        // get rid of specialFront
        this.first = this.first.next;
        return this;

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