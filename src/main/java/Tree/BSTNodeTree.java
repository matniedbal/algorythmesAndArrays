package Tree;

import java.util.Comparator;

public class BSTNodeTree<E> {

    private Node<E> root;
    private final Comparator<E> comparator;
    private Node<E> actualNode;
    private int tries;


    public Node<E> getRoot() {
        return root;
    }

    public BSTNodeTree(Comparator<E> comparator) {

        this.tries = 0;
        this.comparator = comparator;
    }

    public void addInner(Node<E> actual, E value) {
        int resultComparator = comparator.compare(value, actual.getValue());

        boolean greater = resultComparator >= 0;

        if (greater) {
            if (actual.getRightChild() != null) {
                addInner(actual.getRightChild(), value);
            } else {
                Node<E> newNodeToAdd = new Node<>(value, null, null);
                actual.setRightChild(newNodeToAdd);
            }
        } else {
            if (actual.getLeftChild() != null) {
                addInner(actual.getLeftChild(), value);
            } else {
                Node<E> newNodeToAdd = new Node<>(value, null, null);
                actual.setLeftChild(newNodeToAdd);
            }
        }

    }

    public void add(E value) {
        if (this.root == null) {
            this.root = new Node<>(value, null, null);
            this.actualNode = this.root;
        } else {
            addInner(this.root, value);
        }
    }


    private E innerMaxValue() {
        if (this.actualNode != null) {
            if (this.actualNode.getRightChild() == null)
                return actualNode.getValue();
            else {
                this.actualNode = this.actualNode.getRightChild();
                return innerMaxValue();
            }
        }
        return null;
    }


    private E innerMinValue() {
        if (this.actualNode != null) {
            if (this.actualNode.getLeftChild() == null) return actualNode.getValue();
            else {
                this.actualNode = this.actualNode.getLeftChild();
                return innerMinValue();
            }
        }

        return null;
    }


    public E getMaxValue() {
        this.actualNode = this.root;
        return innerMaxValue();
    }

    public E getMinValue() {
        this.actualNode = this.root;
        return innerMinValue();
    }


    public boolean innerFindValue(E value){
        this.tries++;
        if(actualNode != null){
            int resultComparator = comparator.compare(value, actualNode.getValue());
            boolean greater = resultComparator > 0;
            if(comparator.compare(actualNode.getValue(),value)==0) return true;
            if(greater){
                if(actualNode.getRightChild()==null) return false;
                else{
                    actualNode = actualNode.getRightChild();
                    return innerFindValue(value);
                }
            }else{
                if(actualNode.getLeftChild()==null) return false;
                else{
                    actualNode = actualNode.getLeftChild();
                    return innerFindValue(value);
                }
            }
        }
            return false;
    }

    public int getTries() {
        return tries;
    }

    public boolean findValue (E value){
        this.actualNode = this.root;
        return innerFindValue(value);
    }

}



// ************************> NODE <*******************************

class Node<E> {

    private E value;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node() {
    }

    public Node(E value, Node<E> leftChild, Node<E> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public E getValue() {
        return value;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }


    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

}
