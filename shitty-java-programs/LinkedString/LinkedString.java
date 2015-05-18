//Linked List of strings

public class LinkedString {
    Node first;
    Node last;
    int length;

    public LinkedString() {
    }

    public void append(String data) {
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

    public void prepend(String data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        }
        else {
            Node temp = first;
            first = new Node(data);
            first.next = temp;
        }
        length++;
    }

    public int length() {
        return length;
    }

    public String getAt(int i) {
        if (length == 0) {
            return null;
        }
        else if ((i > length-1) || (i < 0)) {
            throw new ArrayIndexOutOfBoundsException("" + i);
        }
        else {
            Node curr = first;
            for (int x=0; x < i; x++) {
                curr = curr.next;
            }
            return curr.data;
        }
    }



    @Override public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        Node curr = first;
        while  (curr != null) {
            output.append(curr.data);
            if (curr.next != null)
                output.append(", ");
            curr = curr.next;
        }
        output.append("]");
        return output.toString();
    }


}