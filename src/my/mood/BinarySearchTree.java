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

    }
}
