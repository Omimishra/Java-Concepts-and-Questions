package tree;

public class subtree {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

    }

    static class binarytree {
        static int i = -1;
        
        public node build_tree(int nodes[]) {
            i++;
            if (nodes[i] == -1) {
                return null;
            }

            node newnode = new node(nodes[i]);
            newnode.left = build_tree(nodes);
            newnode.right = build_tree(nodes);
            return newnode;

        }
    
        static int j = -1;
        public node build_subtree(int nodes2[]) {
            j++;
            if (nodes2[j] == -1) {
                return null;
            }

            node newNode = new node(nodes2[j]);
            newNode.left = build_subtree(nodes2);
            newNode.right = build_subtree(nodes2);
            return newNode;

        }
    }

    public static boolean isIdentical(node root, node subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null) {
            return false;
        }
        if (root.data == subroot.data) {
            return isIdentical(root.left, subroot) && isIdentical(root.right, subroot);
        }
        return false;
    }

    public static boolean isSubtree(node root, node subroot) {
        if (subroot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes2[] = {2,4,-1,-1,5,-1,-1};
        binarytree tree = new binarytree();

        node root = tree.build_tree(nodes);
node subroot = tree.build_subtree(nodes2);
System.out.println(isSubtree(root, subroot));
    }
}
