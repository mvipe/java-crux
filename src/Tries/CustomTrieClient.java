package Tries;

public class CustomTrieClient {
    public static void main(String[] args) {
        CustomTrie trie=new CustomTrie();
        trie.addWord("amit");
        trie.addWord("ashutosh");
        trie.addWord("aman");
        trie.addWord("ashu");

        trie.remove("ashutosh");

        trie.display();
        System.out.println(trie.search("ashutosh"));


    }
}
