package sait.sll.utility;
import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {

    private static final long serialVersionUID = 1L;

    private Node head;
    private int size;

    public SLL() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void append(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void prepend(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void insert(Object data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            prepend(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        Node newNode = new Node(data);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    @Override
    public void replace(Object data, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setData(data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public Object retrieve(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    @Override
    public int indexOf(Object data) {
        Node current = head;
        int index = 0;

        while (current != null) {
        	if ((current.getData() == null && data == null) ||
        		    (current.getData() != null && current.getData().equals(data)))
            	return index;
            current = current.getNext();
            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }
}
