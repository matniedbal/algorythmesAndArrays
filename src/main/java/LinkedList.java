import java.util.Comparator;

public class LinkedList<E> implements Lista {

    private Node firstNode;
    private Node lastNode;

    public LinkedList() {
    }

    public E getFirstNode() {
        return (E) this.firstNode.getValue();
    }

    public E getLastNode() {
        return (E) this.lastNode.getValue();
    }


    @Override
    public Object get(int index) throws NullPointerException{

        if(!isEmpty()) {
            Node actual = this.firstNode;
            for (int i = 0; i < index; i++) {
                actual = actual.getNext();

            }
            return actual.getValue();
        }else return null;
    }

    @Override
    public void add(Object elem) {
        if(this.firstNode==null && this.lastNode==null) this.firstNode = new Node(elem,null,null);
        else if(this.firstNode!=null  && this.lastNode==null){
            this.lastNode = new Node(elem,null,this.firstNode);
            this.firstNode.setNext(this.lastNode);

        }
        else if(this.firstNode!=null  && this.lastNode!=null) {
            Node actual;

            actual = new Node(elem,null,this.lastNode);
            this.lastNode.setNext(actual);
            this.lastNode = actual;
        }
    }

    @Override
    public void remove(Object elem) {
        if(!isEmpty()) {
            Node actual = this.firstNode;
            for (int i = 0; i < size(); i++) {
                if (actual.getValue().equals(elem)) {
                    if (actual.equals(this.firstNode)) {
                        this.firstNode = actual.getNext();
                    } else if (actual.equals(this.lastNode)) {
                        this.lastNode = actual.getPrevious();
                    } else {
                        actual.getNext().setPrevious(actual.getPrevious());
                        actual.getPrevious().setNext(actual.getNext());
                    }
                }
                actual = actual.getNext();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public int size() {
        int size = 0;

        Node actual = this.firstNode;
        if(this.firstNode!=null) {
            size = 1;
            while (!actual.equals(this.lastNode)) {
                size++;
                actual = actual.getNext();
            }
        }
            return size;

    }


    @Override
    public boolean isSorted(Comparator comparator) {
        for (int i = 0; i < size()-1; i++) {
            if(comparator.compare(get(i),get(i+1)) != 1) return false;
        }
        return true;
    }

    @Override
    public boolean exist(Object elem) {
        if (!isEmpty()) {
        Node actual = this.firstNode;
            do {
                if (actual.getValue().equals(elem)) return true;
                actual = actual.getNext();

            } while (!actual.equals(this.lastNode));
        }
            return false;
    }

    @Override
    public int getIndex(Object elem) {
        int index = 0;

        Node actual = this.firstNode;
        if(!isEmpty()) {
            while (!actual.equals(this.lastNode)){
                actual = actual.getNext();
                index++;
            }
            return index;
        }else return -1;
    }

    @Override
    public String toString() {
        String temp = "";
        Node actual = this.firstNode;
        if(this.firstNode!=null)  {
            temp = "["+actual.getValue()+", ";
            for (int i = 1; i < size()-1; i++) {
                actual = actual.getNext();
                temp = temp + actual.getValue()+", ";
            }
            if(size() > 1) temp = temp+lastNode.getValue()+"]";
            else temp = temp+"]";
        }
        return temp;
    }

}

class Node<E> {

    private Node next;
    private Node previous;
    private int index;
    private E value;

    public Node(E value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
        if(previous==null) this.index = 0;
        else this.index = this.previous.index++;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getValue() {
        return value;
    }
}
