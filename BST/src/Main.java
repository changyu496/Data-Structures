public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 2, 4, 7};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        bst.inOrder();
//        bst.postOrder();
//        bst.levelOrder();
//        System.out.println(bst);
//        System.out.println(bst.minmum());
//        System.out.println(bst.maxmum());
        System.out.println(bst);
        bst.removeMin();
        System.out.println(bst);
        bst.removeMax();
        System.out.println(bst);
    }


}
