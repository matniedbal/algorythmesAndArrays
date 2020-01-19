package Tree;

public class Main {

    public static <E> void main(String... args) {
//        BinnaryTree binnaryTree = new BinnaryTree();
//        System.out.println("Root: "+binnaryTree.getRoot());
//        System.out.println("Left child of root: "+binnaryTree.getLeftChildOfRoot()+", right child of root: "+binnaryTree.getRightChildOfRoot());
//        System.out.println("All leafs: "+binnaryTree.getAllLeafs());
//        System.out.println("All left children: "+binnaryTree.getAllLeftChildren());

        BSTNodeTree<Integer> binnaryTree = new BSTNodeTree<>(Integer::compareTo);
        int listLength = 1000;
        long startTime, endTime;
        int numberRange = 1000;

        binnaryTree.add(28);
        binnaryTree.add(19);
        binnaryTree.add(4);
        binnaryTree.add(52);
        binnaryTree.add(39);
        binnaryTree.add(45);
        binnaryTree.add(47);
        binnaryTree.add(27);
        binnaryTree.add(4);
        binnaryTree.add(9);
        binnaryTree.add(40);
        binnaryTree.add(3);
        binnaryTree.add(55);
//        for(int i = 0; i < listLength; i++){
//            int added = (int) (Math.random()*numberRange);
//            binnaryTree.add(added);
//


//            System.out.print(added+" ");
//        }
//        System.out.println(" ]");
//        binnaryTree.inOrder();
//        System.out.println("Next: "+binnaryTree.next(binnaryTree.findByValue(3)).getValue());
//        System.out.println("find: "+binnaryTree.findValue(num1)+" result found in "+binnaryTree.getTries()+" tries");
//        System.out.println("Min value: "+binnaryTree.getMin().getValue()+" result found in "+binnaryTree.getTries()+" tries"+" \nMax value: "+binnaryTree.getMax().getValue()+" result found in "+binnaryTree.getTries()+" tries");
//            System.out.print(binnaryTree.showChildren(num1));
//        System.out.println("Value: "+binnaryTree.findByValue(num1).getValue());
//        startTime = System.nanoTime();
//        System.out.println("next "+binnaryTree.next(binnaryTree.findByValue(num1)).getValue());
//        endTime = System.nanoTime();
//        System.out.println("next time: "+ (endTime-startTime));
//
//        startTime = System.nanoTime();
//        System.out.println("next2 "+binnaryTree.next2(binnaryTree.findByValue(num1)).getValue());
//        endTime = System.nanoTime();
//        System.out.println("next2 time: "+ (endTime-startTime));
//
//        startTime = System.nanoTime();
//        System.out.println("previous "+binnaryTree.previous(binnaryTree.findByValue(num1)).getValue());
//        endTime = System.nanoTime();
//        System.out.println("previous time: "+ (endTime-startTime));
//        startTime = System.nanoTime();
//        System.out.println("previous2 "+binnaryTree.previous2(binnaryTree.findByValue(num1)).getValue());
//        endTime = System.nanoTime();
//        System.out.println("previous2 time: "+ (endTime-startTime));
//        startTime = System.nanoTime();
//        binnaryTree.previous2(binnaryTree.findByValue(67));
//        System.out.println("previous time: "+ (System.nanoTime()-startTime)/1000);
        //        System.out.println();
//        binnaryTree.postOrder();
//        binnaryTree.preOrder();
//        binnaryTree.inOrder();
//        binnaryTree.inOrderReversed();
//        System.out.println("Root: "+binnaryTree.getRoot().getValue());
//        System.out.print("Leaves: ");
//        System.out.println(binnaryTree.leavesOrder());
//        System.out.println("Leaves by function: "+ binnaryTree.getLeafValuesFunc());
//        System.out.println("Sum of all: "+binnaryTree.sum());
//        System.out.print("One child owners: ");
//        binnaryTree.oneChildOrder();
//        System.out.println("Size, my version: "+binnaryTree.topsCount());
//        System.out.println("Size: "+ binnaryTree.size());
//        System.out.println("Size Atomic: "+ binnaryTree.getSizeAtomic());
//        System.out.println("Height: "+ binnaryTree.height());
//        System.out.println();
//        System.out.println(binnaryTree.print());
        int num1 = 19;


        binnaryTree.postOrder();

        System.out.println("size: "+binnaryTree.size());
        System.out.println("number to remove: "+ num1);
        System.out.println("next to number to remove: "+binnaryTree.next(binnaryTree.findByValue(num1)).getValue());
        binnaryTree.remove(binnaryTree.findByValue(num1));
        System.out.println("size: "+binnaryTree.size());

        System.out.println("actual root: "+binnaryTree.getRoot().getValue());
//        System.out.println("39 rightCH. "+binnaryTree.getRightChildByValue(39).getValue());
//        System.out.println("39 leftCH. "+binnaryTree.getLeftChildByValue(39));
//        System.out.println("40 parent: "+binnaryTree.getParentByValue(40).getValue());
        binnaryTree.postOrder();


    }
}
