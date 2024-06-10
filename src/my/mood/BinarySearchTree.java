package my.mood;

public class BinarySearchTree {
    public TreeNode root;

    public static class TreeNode{
        public int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree(){
        this.root = null;
    }

    // Insert in Binary Search Tree
    public void insert(int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value){
        if (root == null){
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data){
            root.left = insert(root.left, value);
        }
        else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // printing node using in-order traversal
    public void print(){
        print(root);
    }

    public void print(TreeNode root){
        if (root == null){
            return;
        }

        print(root.left);
        System.out.print(root.data+ " ");
        print(root.right);
    }

    // search key in binary search tree
    public TreeNode searchKey(int search, TreeNode root){
        if(root == null || search == root.data){
            return root;
        }
        if(search < root.data){
            return searchKey(search, root.left);
        }
        else {
            return searchKey(search, root.right);
        }
    }

    // checking whether a BST is validated or not
    public boolean isValidate(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }

        if (root.data >= max || root.data <= min){
            return false;
        }

        boolean left = isValidate(root.left, min, root.data);

        if (left){
            boolean right = isValidate(root.right, root.data, max);
            return right;
        }

        return false;
    }

    // create binary search tree
    public void binaryST(){
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(7);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(9);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

    }
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // Insert in Binary Search Tree
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);
        binarySearchTree.insert(7);
        binarySearchTree.print();

        // search key in binary search tree
        if (binarySearchTree.searchKey(8, binarySearchTree.root) != null){
            System.out.println("\nSearch key found!");
        }
        else{
            System.out.println("\nSearch key not found!");
        }

        BinarySearchTree binarySearchTree1 = new BinarySearchTree();
        binarySearchTree1.binaryST();
        binarySearchTree1.print();
        if (binarySearchTree1.isValidate(binarySearchTree1.root, Long.MIN_VALUE, Long.MAX_VALUE)){
            System.out.println("\nBinary search tree is validate");
        }
        else {
            System.out.println("\nBinary search tree is not validate");
        }
    }
}
