package my.mood;

public class BinaryTree {

    // Creating instance variable root
    public TreeNode root;
    public BinaryTree(){
        this.root = null;
    }

    public static class TreeNode{
        public int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(1);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(1);

        root = first;
        first.left = second;
        first.right = third;
        second.right = fourth;
        third.left = fifth;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
    }
}
