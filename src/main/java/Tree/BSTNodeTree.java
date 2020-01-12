package Tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BSTNodeTree<E> {

    private Node<E> root;
    private final Comparator<E> comparator;
    private Node<E> actualNode;
    private int tries;


    public Node<E> getRoot() {
        return root;
    }

    public BSTNodeTree(Comparator<E> comparator) {

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


    private Node<E> innerMaxValue() {
        this.tries++;

        if (this.actualNode != null) {
            if (this.actualNode.getRightChild() == null)
                return actualNode;
            else {
                this.actualNode = this.actualNode.getRightChild();
                return innerMaxValue();
            }
        }
        return null;
    }


    private Node<E> innerMinValue() {
        this.tries++;

        if (this.actualNode != null) {
            if (this.actualNode.getLeftChild() == null) return actualNode;
            else {
                this.actualNode = this.actualNode.getLeftChild();
                return innerMinValue();
            }
        }

        return null;
    }


    public Node<E> getMax() {
        this.tries = 0;
        this.actualNode = this.root;
        return innerMaxValue();
    }

    public Node<E> getMin() {
        this.tries = 0;
        this.actualNode = this.root;
        return innerMinValue();
    }


    private Node<E> findByValue(E value){
        this.tries++;
        if(actualNode != null){
            int resultComparator = comparator.compare(value, actualNode.getValue());
            boolean greater = resultComparator > 0;
            if(comparator.compare(actualNode.getValue(),value)==0) return this.actualNode;
            if(greater){
                if(actualNode.getRightChild()==null) return null;
                else{
                    actualNode = actualNode.getRightChild();
                    return findByValue(value);
                }
            }else{
                if(actualNode.getLeftChild()==null) return null;
                else{
                    actualNode = actualNode.getLeftChild();
                    return findByValue(value);
                }
            }
        }
            return null;
    }

    public int getTries() {
        return tries;
    }

    public boolean findValue (E value){
        this.tries = 0;
        this.actualNode = this.root;
        if(findByValue(value) != null)
        return true;
        else return false;
    }


    public List<E> showChildren(E value){
        this.actualNode = this.root;
        List<E> temp = new LinkedList<>();
        if(findByValue(value) != null) {
            if (findByValue(value).getRightChild() != null) {
                temp.add(findByValue(value).getRightChild().getValue());
            }
            if (findByValue(value).getLeftChild() != null) {
                temp.add(findByValue(value).getLeftChild().getValue());
            }
        }
        return temp;
    }

    public void postOrder() {
        postOrderInner(this.root);
        System.out.println();
    }

    private void postOrderInner(Node<E> node) {
        if(node != null) {
            postOrderInner(node.getLeftChild());
            postOrderInner(node.getRightChild());
            System.out.print (node.getValue()+" ");
        }
    }

    private void inOrderInner(Node<E> node) {
        if(node!= null){
            inOrderInner(node.getLeftChild());
            System.out.print (node.getValue()+" ");
            inOrderInner(node.getRightChild());

        }
    }

    public void inOrder(){
        inOrderInner(root);
        System.out.println();
    }

    private void inOrderReversedInner(Node<E> node) {
        if(node!= null){
            inOrderReversedInner(node.getRightChild());
            System.out.print (node.getValue()+" ");
            inOrderReversedInner(node.getLeftChild());

        }
    }

    public void inOrderReversed(){
        inOrderReversedInner(root);
        System.out.println();
    }

    private void preOrderInner(Node<E> node) {
        if(node!= null){
            System.out.print (node.getValue()+" ");
            preOrderInner(node.getRightChild());
            preOrderInner(node.getLeftChild());

        }
    }

    public void preOrder(){
        preOrderInner(root);
        System.out.println();
    }

    private void topsCountInner(Node<E> node){
        if(node != null) {
            tries ++;
            topsCountInner(node.getLeftChild());
            topsCountInner(node.getRightChild());
        }
    }

    public int topsCount(){
        this.tries = 0;
        topsCountInner(root);
        return this.tries;
    }

    private void leafesOrderInner(Node<E> node){
        if(node != null) {

            leafesOrderInner(node.getLeftChild());
            leafesOrderInner(node.getRightChild());
            if(node.getLeftChild()==null && node.getRightChild() == null )
                System.out.print(node.getValue()+" ");
        }
    }

    public void leavesOrder(){
        this.tries = 0;
        leafesOrderInner(root);
        System.out.println();
    }


    private void sumInner(Node<Integer> node){
        if(node != null) {
            sumInner(node.getLeftChild());
            sumInner(node.getRightChild());
            tries += node.getValue();
        }
    }



    public int sum(){
        this.tries = 0;
        sumInner((Node<Integer>) root);
        return this.tries;
    }


    private void oneChildOrderInner(Node<E> node){
        if(node != null) {

            oneChildOrderInner(node.getLeftChild());
            oneChildOrderInner(node.getRightChild());
            if(node.getLeftChild()==null || node.getRightChild() == null )
                System.out.print(node.getValue()+" ");
        }
    }

    public void oneChildOrder(){
        oneChildOrderInner(root);
        System.out.println();
    }

    private int sizeInner(Node<E> node, int counter){
        if(node != null) {
            counter = sizeInner(node.getLeftChild(), counter);
            counter = sizeInner(node.getRightChild(), counter);
            ++counter;
        }
        return counter;
    }

    public int size(){
        return sizeInner(root, 0);
    }

    public AtomicInteger getSizeAtomic() {
        AtomicInteger acc = new AtomicInteger();
        return getSizeAtomic(root, acc);
    }

    private AtomicInteger getSizeAtomic(Node<E> node, AtomicInteger counter) {
        if(node != null) {
            counter = getSizeAtomic(node.getLeftChild(), counter);
            counter = getSizeAtomic(node.getRightChild(), counter);
            counter.set(counter.get() + 1);
        }
        return counter;
    }

    private List<Integer> heightInner(Node<E> node, int counter){
        if(node != null) {
            if (node.getRightChild() != null || node.getLeftChild() != null) {
                counter++;
                heightInner(node.getLeftChild(), counter);
                heightInner(node.getRightChild(), counter);
            }
            heightList.add(counter);
        }

        return heightList;
    }

    public List<Integer> heightList;

    public int height(){
        heightList = new LinkedList<>();
        return heightInner(root, 0).stream().max(Integer::compareTo).get();
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
