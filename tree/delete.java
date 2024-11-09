package tree;

public class delete {
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

    public static node deleteNode(node root, int val) {

        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else { // root.data == val

            // case 1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 two child
            node IS = inorderSuccessor(root.right); // found the inorder successor node from the right subtree
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data); // updated right subtree and delelted the inorder successor
                                                          // node
        }

        return root;
    }

    public static node inorderSuccessor(node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        deleteNode(root, 4);
        inorder(root);
    }
}