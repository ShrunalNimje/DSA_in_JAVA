package my.mood;

public class Trie {

    public TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    // Representation of Trie using TrieNode
    public static class TrieNode {
        public TrieNode [] children;
        public boolean isWord;

        public TrieNode(){
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    // Insertion of Words in Trie
    public void insert(String word){
        if (word.isEmpty()){
            throw new IllegalArgumentException("Invalid input or word!");
        }

        word = word.toLowerCase();
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null){
                TrieNode newNode = new TrieNode();
                current.children[index] = newNode;
                current = newNode;
            }
            else {
                current = current.children[index];
            }
        }

        current.isWord = true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ball");
        trie.insert("basket");
        trie.insert("catch");
        trie.insert("camera");
        trie.insert("crunch");
        System.out.println("words inserted to trie successfully!");
    }
}
