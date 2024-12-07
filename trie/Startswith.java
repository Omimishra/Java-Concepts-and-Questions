package trie;

public class Startswith {
    static class node {
        node children[];
        boolean eow;

        node() {
            children = new node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static node root = new node();

    public static void insert(String word) {
        node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }

    }
    public static boolean startswith(String word){
        node curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String words []={"apple","app","mango","man","woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String prefix = "app";
        System.out.println(startswith(prefix));
    }
}
