package trie;

public class basic {

    static class node {
        node[] children;
        boolean eow;

        public node() {
            children = new node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
            eow = false;
        }
    }

    static node root = new node();// if a static var changes once it is changed for ever

    public static void insert(String word) { //O(L)
        node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                // creating new node at that idx
                curr.children[idx] = new node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
        curr = curr.children[idx];
        }
    }

    public static boolean search(String word) { // O(L)
        node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                // no node exists here
                return false;
            }
            if (i == word.length() - 1 && curr.children[idx].eow == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there",
                "their", "any" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(search("their"));// true
        System.out.println(search("thor")); // false
        System.out.println(search("an"));// false
    }

}
