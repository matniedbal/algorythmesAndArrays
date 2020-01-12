package Tree;

public class Main {

    public static void main(String... args){
//        BinnaryTree binnaryTree = new BinnaryTree();
//        System.out.println("Root: "+binnaryTree.getRoot());
//        System.out.println("Left child of root: "+binnaryTree.getLeftChildOfRoot()+", right child of root: "+binnaryTree.getRightChildOfRoot());
//        System.out.println("All leafs: "+binnaryTree.getAllLeafs());
//        System.out.println("All left children: "+binnaryTree.getAllLeftChildren());

        BSTNodeTree<Integer> binnaryTree = new BSTNodeTree<>(Integer::compareTo);
        binnaryTree.add(9);
        binnaryTree.add(1);
        binnaryTree.add(16);
        binnaryTree.add(6);
        binnaryTree.add(19);
        binnaryTree.add(0);
        binnaryTree.add(10);
        binnaryTree.add(3);
        binnaryTree.add(4);
        binnaryTree.add(5);
        binnaryTree.add(6);
        binnaryTree.add(8);
        binnaryTree.add(11);
        binnaryTree.add(12);
        System.out.println("find: "+binnaryTree.findValue(12)+" result found in "+binnaryTree.getTries()+" tries");
        System.out.println("Min value: "+binnaryTree.getMinValue()+", Max value: "+binnaryTree.getMaxValue());

    }
}
