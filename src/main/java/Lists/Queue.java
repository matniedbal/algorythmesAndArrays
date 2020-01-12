package Lists;

import java.util.LinkedList;
import java.util.List;

public class Queue<E> {

    private Node firstNode;
    private Node lastNode;

    public Queue() {
    }

    public void add(E value){
        Node actual = new Node(null,null,value);
        if(this.firstNode == null) {
            this.firstNode = actual;
            this.lastNode = this.firstNode;
        }
        else if(this.firstNode.equals(this.lastNode)) {
            actual.previous = this.firstNode;
            this.lastNode = actual;
            this.firstNode.next=this.lastNode;

        }else{
            actual.previous = this.lastNode;
            this.lastNode.next = actual;
            this.lastNode = actual;
        }
    }

    public Node getNodeByIndex(int index){
        Node actual = this.firstNode;
        for (int i = 0; i < index; i++) {
            if (actual.next == null) {
                System.out.println("Gone out of bound");
                break;
            }
            actual = actual.next;
        }
        return actual;
    }

    public void quit(int index){
        Node actual = getNodeByIndex(index);
        if(actual.equals(this.firstNode)) {
            this.firstNode.next.previous = null;
            this.firstNode = this.firstNode.next;

        }else if (actual.equals(this.lastNode)) {
            this.lastNode.previous.next=null;
            this.lastNode=this.lastNode.previous;
        }
        else {
            actual.previous.next = actual.next;
            actual.next.previous = actual.previous;
        }
    }

    public List<E> seveAll(){
        Node actual = this.firstNode;
        List<E> tempList = new LinkedList<>();
        int counter = 0;
        while(actual.next!=null) {
            tempList.add(actual.value);
            quit(counter);
            actual = actual.next;
            counter++;
        }
        return tempList;
    }


    public void remove(int index){
        Node actual = getNodeByIndex(index);
        if(index == 0) {
            this.firstNode.next.previous = null;
            this.firstNode = this.firstNode.next;
            actual.previous=this.lastNode;
            this.lastNode.next = actual;
            actual.next=null;
            this.lastNode=actual;

        }else if (actual.equals(this.lastNode)) System.out.println("Last will be always last");
        else {
            actual.previous.next = actual.next;
            actual.next.previous = actual.previous;
            actual.next = null;
            actual.previous = this.lastNode;
            this.lastNode.next = actual;
            this.lastNode = actual;
        }

    }



    public String toString(boolean isIndex){
        String temp = "";
        Node actual;
        if(firstNode!=null){
            actual = firstNode;
                int counter = 0;
                temp = "{" + firstNode.value.toString();
                if(isIndex) temp = temp+ "["+counter+"]";
                while (actual.next!=null) {
                    counter++;
                    actual = actual.next;
                    temp = temp+ ", " + actual.value.toString();
                    if(isIndex) temp = temp+"["+counter+"]";
                }
            temp += "}";
        }
        return temp;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public class Node{

        private Node next;
        private Node previous;
        private E value;

        public Node(Node next, Node previous, E value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }
    }

}
