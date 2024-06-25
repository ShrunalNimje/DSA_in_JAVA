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

    public static void main(String[] args) {
        Trie trie = new Trie();
    }
}
