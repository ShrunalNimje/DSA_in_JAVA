package my.mood;

import java.util.Stack;

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
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.right = fourth;
        third.left = fifth;
    }

    // Recursive PreOrder Binary Tree
    public void preOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // Iterative PreOrder Binary Tree
    public void preOrderIterative(){
        System.out.println();
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+ " ");

            if (temp.right != null){
                stack.push(temp.right);
            }

            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    // Recursive InOrder Binary Tree
    public void inOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        inOrderRecursive(root.left);
        System.out.print(root.data+ " ");
        inOrderRecursive(root.right);
    }

    // Iterative InOrder Binary Tree
    public void inOrderIterative(){
        System.out.println();
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    // Recursive PostOrder Binary Tree
    public void postOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative PostOrder Binary Tree
    public void postOrderIterative(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        System.out.println();
        if (root == null){
            return;
        }

        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if (temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data +" ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        // Pre-order Binary Tree
        binaryTree.preOrderRecursive(binaryTree.root);
        binaryTree.preOrderIterative();

        // In-order Binary Tree
        System.out.println();
        binaryTree.inOrderRecursive(binaryTree.root);
        binaryTree.inOrderIterative();

        // Post-order Binary Tree
        System.out.println();
        binaryTree.postOrderRecursive(binaryTree.root);
        binaryTree.postOrderIterative();
    }
}
