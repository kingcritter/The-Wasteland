public class LinkedList<E> {
    class Node {
        E data;
        Node next;
        Node prev;
        public Node(E data) {
            this.data = data;
        }
        public Node() {
        }
    }

    private Node first;
    private Node last;
    private int length;

    public LinkedList() {
    }

    // constructer that accepts a list of elements
    public LinkedList(E[] listOfElements) {
        if (listOfElements != null) {
            for (E item : listOfElements) {
                this.append(item);
            }
        }
    }

    // returns length
    public int length() {
        return length;
    }

    // adds an item to the end of a list
    public void append(E item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        }
        else {
            last.next = new Node(item);
            last.next.prev = last;
            last = last.next;
        }
        length++;
    }

    // adds an item to the beginning of the list
    public void prepend(E item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        }
        else {
            Node temp = new Node(item);
            first.prev = temp;
            temp.next = first;
            first = temp;
        }
        length++;
    }

    // removes the element at index i, modifying the list
    public void removeInline(int i) {
        Node temp = getNodeAt(i);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        length--;
    }

    // removes the element at index i, returning a new list an leaving
    // this one alone. 
    public LinkedList<E> remove(int i) {
        LinkedList<E> newList = copy(this);
        newList.removeInline(i);
        return newList;
    }


    // retruns the data at index i
    public E getAt(int i) {
        return getNodeAt(i).data;
    }

    // returns the node at index i
    private Node getNodeAt(int i) {
        if (i < 0 || i >= length)
            throw new IndexOutOfBoundsException("Index '" + i + "' invalid");
        Node curr = first;
        for (int x = 0; x != i; x++) {
            curr = curr.next;
        }
        return curr;
    }

    // returns a new list that hold the same data
    private LinkedList<E> copy(LinkedList<E> list) {
        LinkedList<E> newList = new LinkedList<E>(); 
        for (Node curr = list.first; curr != null; curr = curr.next) {
            newList.append(curr.data);
        }
        return newList;
    }

    // returns a new list that's a subsection of this one
    public LinkedList<E> substring(int start, int end) {
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        Node curr = getNodeAt(start);
        LinkedList<E> newList = new LinkedList<E>();
        for (int i = 0; i < end-start; i++) {
            newList.append(curr.data);
            curr = curr.next;
        }
        return newList;
    }

    public void replaceInline() {
    } 
    // replaces a subsection of the list, returns the new version
    public LinkedList<E> replace(int start, int end, LinkedList<E> substitute) {
        // checks to see if start and end are okay
        if ((start > end) || (start < 0) || (end < 0) || (end > this.length))
            throw new IndexOutOfBoundsException("Start: " + start + " End: " + end);
        // create new list that's a copy of this one
        LinkedList<E> newList = copy(this);
        // set length
        newList.length = this.length + substitute.length - (end-start);
        // copy substitute data to new LinkedList 
        LinkedList<E> tempList = copy(substitute);
        // assign new node to start at:
        Node specialFront = new Node();
        specialFront.next = newList.first;
        newList.first = specialFront;
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
            newList.last = tempList.last;
        // get rid of specialFront
        newList.first = newList.first.next;
        return newList;
    }

}