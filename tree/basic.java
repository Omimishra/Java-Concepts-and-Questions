// build tree from preorder sequence 
package tree;
public class basic {
    static class node {
        int data;
        node left;
        node right;
        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
         static class binary_tree {
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
        public static void preorder(node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(node root){
            if (root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(node root){
            if (root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
        public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            binary_tree tree = new binary_tree();
            node root = tree.build_tree(nodes);
            // System.out.println(root.data);
            postorder(root);
        }
    }

