package com.joezeo.datastruct.bst;

/**
 * @author Joezeo
 * @date 2020/3/30 13:58
 */
public class Test {

    public static class Data implements Comparable<Data>{
        int data;

        public Data(int data){
            this.data = data;
        }
        @Override
        public int compareTo(Data data) {
            if(this.data > data.data){
                return 1;
            }
            if(this.data < data.data){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(10);
        bst.put(15);
        bst.put(5);
        bst.put(8);
        bst.put(18);
        bst.put(3);
//        System.out.println(bst.serach(10));
//        System.out.println(bst.serach(15));
//        System.out.println(bst.serach(5));
//        System.out.println(bst.serach(45));
//        System.out.println(bst.size());

//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
        bst.preorder();
        bst.inorder();
        bst.postorder();
    }
}
