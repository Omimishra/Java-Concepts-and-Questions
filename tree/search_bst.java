package tree;

public class search_bst {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    public static node insert(node root, int val) {
        if (root == null) {
            root = new node(val);
            return root;
        }

        if (root.data > val) {

            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(node root, int key) { // time complexity O(H)

        if (root == null) {
            return false;
        }

        if (root.data > key) {
            // left subtree
            return search(root.left, key);

        } else if (root.data == key) {

            return true;

        } else {
            // right subtree
            return search(root.right, key);

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }

        if (search(root, 1)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}