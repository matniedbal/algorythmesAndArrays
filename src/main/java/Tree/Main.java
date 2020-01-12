package Tree;

public class Main {

    public static void main(String... args){
//        BinnaryTree binnaryTree = new BinnaryTree();
//        System.out.println("Root: "+binnaryTree.getRoot());
//        System.out.println("Left child of root: "+binnaryTree.getLeftChildOfRoot()+", right child of root: "+binnaryTree.getRightChildOfRoot());
//        System.out.println("All leafs: "+binnaryTree.getAllLeafs());
//        System.out.println("All left children: "+binnaryTree.getAllLeftChildren());

        BSTNodeTree<Integer> binnaryTree = new BSTNodeTree<>(Integer::compareTo);
        int listLength = 70;
        int numberRenge = 70;
        int numbToFind = 8;
        for(int i = 0; i < listLength; i++){
            binnaryTree.add((int) (Math.random()*numberRenge));
        }
        System.out.println("find: "+binnaryTree.findValue(numbToFind)+" result found in "+binnaryTree.getTries()+" tries");
        System.out.println("Min value: "+binnaryTree.getMin().getValue()+" result found in "+binnaryTree.getTries()+" tries"+" \nMax value: "+binnaryTree.getMax().getValue()+" result found in "+binnaryTree.getTries()+" tries");
            System.out.print(binnaryTree.showChildren(numbToFind));


        System.out.println();
        binnaryTree.postOrder();
        binnaryTree.preOrder();
        binnaryTree.inOrder();
        binnaryTree.inOrderReversed();
        System.out.print("Leaves: ");
        binnaryTree.leavesOrder();
        System.out.println("Sum of all: "+binnaryTree.sum());
        System.out.print("One child owners: ");
        binnaryTree.oneChildOrder();
        System.out.println("Size, my version: "+binnaryTree.topsCount());
        System.out.println("Size: "+ binnaryTree.size());
        System.out.println("Size Atomic: "+ binnaryTree.getSizeAtomic());
        System.out.println("Height: "+ binnaryTree.height());



    }
}
