package tree;

public class height_of_tree {
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

    static class binary_tree {
        static int i = -1;

        public  node build_tree(int nodes[]) {
            i++;

            if (nodes[i] == -1) {
                return null;
            }
            node newnode = new node(nodes[i]);
            newnode.left = build_tree(nodes);
            newnode.left = build_tree(nodes);

            return newnode;

        }
    }

    public static int height (node root){
        if (root == null){
            return 0 ;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight , rightHeight) + 1;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binary_tree tree = new binary_tree();
        
        node root = tree.build_tree(nodes);
         int ans = height(root);
         System.out.println(ans);
         
    }
}
