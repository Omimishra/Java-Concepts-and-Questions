package tree;

public class operation_on_tree {
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
    }

    public static int height(node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int count(node root) {
        if (root == null) {
            return 0;

        }

        int leftnodes = count(root.left);
        int rightnodes = count(root.right);

        return leftnodes + rightnodes + 1;
    }

    public static int sum(node root) {
        if (root == null) {
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return leftsum + rightsum + root.data;
    }

    public static int diameter(node root) {

        if (root == null) {
            return 0;
        }

        int daim1 = diameter(root.left);
        int daim2 = diameter(root.right);
        int daim3 = height(root.left) + height(root.right) + 1;

        return Math.max(daim1, Math.max(daim2, daim3));
    }

    static class Treeinfo {
        int ht;
        int diam;

        Treeinfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;

        }
    }

    public static Treeinfo diameter2(node root) {
        if (root == null) {
            return new Treeinfo(0, 0);
        }
        Treeinfo left = diameter2(root.left);
        Treeinfo right = diameter2(root.right);

        int myheight = Math.max(left.ht, right.ht) + 1;

        int daim1 = left.diam;
        int daim2 = right.diam;
        int daim3 = left.ht + right.ht + 1;

        int mydaim = Math.max(Math.max(daim1, daim2), daim3);

        Treeinfo myInfo = new Treeinfo(myheight, mydaim);
        return myInfo;

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binarytree tree = new binarytree();

        node root = tree.build_tree(nodes);
        System.out.println(diameter2(root).diam);

    }
}