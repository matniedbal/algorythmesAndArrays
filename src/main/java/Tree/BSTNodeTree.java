package Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

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
                newNodeToAdd.setParent(actual);
                actual.setRightChild(newNodeToAdd);
            }
        } else {
            if (actual.getLeftChild() != null) {
                addInner(actual.getLeftChild(), value);
            } else {
                Node<E> newNodeToAdd = new Node<>(value, null, null);
                newNodeToAdd.setParent(actual);
                actual.setLeftChild(newNodeToAdd);
            }
        }

    }

    public void add(E value) {
        if (this.root == null) {
            this.root = new Node<>(value, null, null);
            this.root.setParent(null);
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


    private Node<E> findByValueInner(E value) throws NullPointerException {
        this.tries++;
        if (actualNode != null) {
            int resultComparator = comparator.compare(value, actualNode.getValue());
            if (comparator.compare(actualNode.getValue(), value) == 0) return this.actualNode;
            if (resultComparator > 0) {
                if (actualNode.getRightChild() == null) return null;
                else {
                    actualNode = actualNode.getRightChild();
                    return findByValueInner(value);
                }
            } else {
                if (actualNode.getLeftChild() == null) return null;
                else {
                    actualNode = actualNode.getLeftChild();
                    return findByValueInner(value);
                }
            }
        }
        return null;
    }

    public Node<E> findByValue(E value) {
        actualNode = root;
        tries = 0;
        return findByValueInner(value);
    }

    public int getTries() {
        return tries;
    }

    public boolean findValue(E value) {
        this.tries = 0;
        this.actualNode = this.root;
        if (findByValue(value) != null)
            return true;
        else return false;
    }


    public List<E> showChildren(E value) {
        this.actualNode = this.root;
        List<E> temp = new LinkedList<>();
        if (findByValue(value) != null) {
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

    private <A> void postOrderInner(Node<E> node) {
        if (node != null) {
            postOrderInner(node.getLeftChild());
            postOrderInner(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }


    public String print() {
        String result = "[" + postOrderInnerTemplate(root, (node, acc) -> {
            return acc.append(node.getValue()).append("]");
        }, new StringBuilder()).toString();
        return result;
    }

    private void inOrderInner(Node<E> node) {
        if (node != null) {
            inOrderInner(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrderInner(node.getRightChild());

        }
    }

    public void inOrder() {
        inOrderInner(root);
        System.out.println();
    }

    private void inOrderReversedInner(Node<E> node) {
        if (node != null) {
            inOrderReversedInner(node.getRightChild());
            System.out.print(node.getValue() + " ");
            inOrderReversedInner(node.getLeftChild());

        }
    }

    public void inOrderReversed() {
        inOrderReversedInner(root);
        System.out.println();
    }

    private void preOrderInner(Node<E> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderInner(node.getRightChild());
            preOrderInner(node.getLeftChild());

        }
    }

    public void preOrder() {
        preOrderInner(root);
        System.out.println();
    }

    private void topsCountInner(Node<E> node) {
        if (node != null) {
            tries++;
            topsCountInner(node.getLeftChild());
            topsCountInner(node.getRightChild());
        }
    }

    public int topsCount() {
        this.tries = 0;
        topsCountInner(root);
        return this.tries;
    }

    List<E> leavesList;

    private List<E> leafesOrderInner(Node<E> node, List<E> acc) {
        if (node != null) {
            leafesOrderInner(node.getLeftChild(), acc);
            leafesOrderInner(node.getRightChild(), acc);
            if (node.getLeftChild() == null && node.getRightChild() == null)
                acc.add(node.getValue());
        }
        return acc;
    }

    private <A> A postOrderInnerTemplate(Node<E> node,
                                         BiFunction<Node<E>, A, A> function,
                                         A acc) {
        if (node != null) {
            postOrderInnerTemplate(node.getLeftChild(), function, acc);
            postOrderInnerTemplate(node.getRightChild(), function, acc);
            function.apply(node, acc);
        }
        return acc;
    }

    public List<E> getLeafValuesFunc() {
        return postOrderInnerTemplate(root, (node, list) -> {
            if (node.getRightChild() == null && node.getLeftChild() == null)
                list.add(node.getValue());
            return list;
        }, new ArrayList<>());
    }

    public List<E> leavesOrder() {
        this.tries = 0;
        leavesList = new LinkedList<>();
        return leafesOrderInner(root, new LinkedList<>());
    }

    private void sumInner(Node<Integer> node) {
        if (node != null) {
            sumInner(node.getLeftChild());
            sumInner(node.getRightChild());
            tries += node.getValue();
        }
    }

    public int sum() {
        this.tries = 0;
        sumInner((Node<Integer>) root);
        return this.tries;
    }

    private void oneChildOrderInner(Node<E> node) {
        if (node != null) {

            oneChildOrderInner(node.getLeftChild());
            oneChildOrderInner(node.getRightChild());
            if ((node.getLeftChild() == null && node.getRightChild() != null) || (node.getRightChild() == null && node.getLeftChild() != null))
                System.out.print(node.getValue() + " ");
        }
    }

    public void oneChildOrder() {
        oneChildOrderInner(root);
        System.out.println();
    }

    private int sizeInner(Node<E> node, int counter) {
        if (node != null) {
            counter = sizeInner(node.getLeftChild(), counter);
            counter = sizeInner(node.getRightChild(), counter);
            ++counter;
        }
        return counter;
    }

    public int size() {
        return sizeInner(root, 0);
    }

    public AtomicInteger getSizeAtomic() {
        AtomicInteger acc = new AtomicInteger();
        return getSizeAtomic(root, acc);
    }

    private AtomicInteger getSizeAtomic(Node<E> node, AtomicInteger counter) {
        if (node != null) {
            counter = getSizeAtomic(node.getLeftChild(), counter);
            counter = getSizeAtomic(node.getRightChild(), counter);
            counter.set(counter.get() + 1);
        }
        return counter;
    }

    private List<Integer> heightInner(Node<E> node, int counter) {
        if (node != null) {
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

    public int height() {
        heightList = new LinkedList<>();
        return heightInner(root, 0).stream().max(Integer::compareTo).get();
    }

    public Node<E> previous(Node<E> node) {
        if (node == null || node == getMin()) {
            return null;
        }
        if (node.getLeftChild() != null) {
            node = node.getLeftChild();
            while (node.getRightChild() != null) {
                node = node.getRightChild();
            }
            return node;
        } else if (node == root) {
            return null;
        } else {
            Node<E> parent = node.getParent();
            boolean hasParentGreaterValue = comparator.compare(parent.getValue(), node.getValue()) > 0;
            while (hasParentGreaterValue && root != parent) {
                parent = parent.getParent();
                hasParentGreaterValue = comparator.compare(parent.getValue(), node.getValue()) > 0;
            }
            return parent;
        }
    }

    public Node<E> findInner(E elem, Node<E> node) {
        if (node == null) return null;
        int result = comparator.compare(elem, node.getValue());
        if (result == 0) return node;
        else if (result > 0) return findInner(elem, node.getRightChild());
        else return findInner(elem, node.getLeftChild());
    }

    private void getListOfNodesSortedByValue(Node<E> node) {
        if (node != null) {
            getListOfNodesSortedByValue(node.getLeftChild());
            sortedListOfNodesByValue.add(node);
            getListOfNodesSortedByValue(node.getRightChild());

        }
    }

    private List<Node<E>> sortedListOfNodesByValue;

//    public Node<E> next2(Node<E> searchedNode){
//        sortedListOfNodesByValue = new LinkedList<>();
//        getListOfNodesSortedByValue(root);
//        for(int i = 0; i < sortedListOfNodesByValue.size(); i++){
//            if(comparator.compare(sortedListOfNodesByValue.get(i).getValue(), searchedNode.getValue())==0 && i+1 != sortedListOfNodesByValue.size())
//                return sortedListOfNodesByValue.get(i+1);
//        }
//        return searchedNode;
//    }


//    public Node<E> previous2(Node<E> searchedNode){
//        sortedListOfNodesByValue = new LinkedList<>();
//        getListOfNodesSortedByValue(root);
//        for(int i = 0; i < sortedListOfNodesByValue.size(); i++){
//            if(comparator.compare(sortedListOfNodesByValue.get(i).getValue(), searchedNode.getValue())==0 && i-1 >= 0)
//                return sortedListOfNodesByValue.get(i-1);
//        }
//        return searchedNode;
//    }

    public Node<E> getRightChildByValue(E value) {
        return findByValue(value).getRightChild();
    }

    public Node<E> getLeftChildByValue(E value) {
        return findByValue(value).getLeftChild();
    }

    public Node<E> getParentByValue(E value) {
        return findByValue(value).getParent();
    }

    public Node<E> next(Node<E> node) throws NullPointerException {
        if (node == null || node == getMax()) {
            return null;
        }
        if (node.getRightChild() != null) {
            node = node.getRightChild();
            while (node.getLeftChild() != null) {
                node = node.getLeftChild();
            }
            return node;
        } else if (node == root) {
            return null;
        } else {
            Node<E> parent = node.getParent();
            boolean hasParentGreaterValue = comparator.compare(parent.getValue(), node.getValue()) < 0;
            while (hasParentGreaterValue && root != parent) {
                parent = parent.getParent();
                hasParentGreaterValue = comparator.compare(parent.getValue(), node.getValue()) < 0;
            }
            return parent;
        }
    }

    public void remove(Node<E> node) {
        this.actualNode = node;

        removeInner(node);
    }

    private void removeInner(Node<E> node) {
        if (node != null) {
            if (node == this.root) {
                if (this.root.getRightChild() == null && this.root.getLeftChild() == null) {
                    this.root = null;
                } else if (this.root.getRightChild() != null && this.root.getLeftChild() != null) {
                    Node<E> nextNode = next(root);
                    this.root.setValue(nextNode.getValue());
                    removeInner(nextNode);
                } else if (this.root.getRightChild() != null && this.root.getLeftChild() == null) {
                    this.root.setValue(this.root.getRightChild().getValue());
                    this.root.setRightChild(null);
                } else if (this.root.getRightChild() == null && this.root.getLeftChild() != null) {
                    this.root.setValue(this.root.getLeftChild().getValue());
                    this.root.setLeftChild(null);
                }

            } else {
                if (node.getRightChild() == null && node.getLeftChild() == null) {
                    if (node.getParent().getRightChild() == node) node.getParent().setRightChild(null);
                    else node.getParent().setLeftChild(null);
                } else if (node.getRightChild() != null && node.getLeftChild() == null) {
                    node.getRightChild().setParent(node.getParent());
                    if (node.getParent().getRightChild() == node) {
                        node.getParent().setRightChild(node.getRightChild());
                    } else node.getParent().setLeftChild(node.getRightChild());
                    node = node.getRightChild();
                } else if (node.getRightChild() == null && node.getLeftChild() != null) {
                    node.getLeftChild().setParent(node.getParent());
                    if (node.getParent().getRightChild() == node) {
                        node.getParent().setRightChild(node.getLeftChild());
                    } else node.getParent().setLeftChild(node.getLeftChild());
                    node = node.getRightChild();
                } else if (node.getRightChild() != null && node.getLeftChild() != null) {
                    Node<E> nextNode = next(node);
                    node.setValue(nextNode.getValue());
                    removeInner(nextNode);
                }
            }
        } else System.out.println("Null pointer");
    }
//
//    public void removeNode(E value) {
//        removeNodeInner(this.root,value);
//    }

//    private Node<E> removeNodeInner(Node<E> actual, E value) {
//        if (actual == null) return null;
//    if (comparator.compare(value, actual.getValue()) < 0) {
//        actual.setLeftChild(removeNodeInner(actual.getLeftChild(), value));
//    } else if (comparator.compare(value, actual.getValue()) > 0) {
//        actual.setRightChild(removeNodeInner(actual.getRightChild(), value));
//    } else {
//        if (actual.getLeftChild() == null && actual.getRightChild() == null) {
//        System.out.println("Deleting: " + value);
//    return null;
//    } else if (actual.getLeftChild() == null) {
//        System.out.println("Deleting: " + value);
//    return actual.getRightChild();
//    } else if (actual.getRightChild() == null){
//        System.out.println("Deleting: " + value);
//    return actual.getLeftChild();
//    } else {
//        E minValue = findMin(actual.getRightChild());
//    findElemRecursion(minValue).setLeftChild(actual.getLeftChild());
//    actual = actual.getRight();
//    System.out.println("Deleting: "+value);            }        }
//    return actual;    }
//    //compareTo    @Override    public int compareTo(@NotNull Node<E> eNode) {        return 0;    }
//
}
//END


// ************************> NODE <*******************************

class Node<E> {

    private E value;
    private Node<E> leftChild;
    private Node<E> rightChild;
    private Node<E> parent;

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

    public void setValue(E value) {
        this.value = value;
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

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }
}
