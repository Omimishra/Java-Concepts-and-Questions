package tree;

import java.util.*;

//BFS is used as we print according to breadth
public class levelorder {
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

    public static void levelOrder(node root) {
        if (root == null) {
            return;
        }

        Queue<node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            node currnode = q.remove();

            if (currnode == null) {
                System.out.println(); // nextline

                // end of queue
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currnode.data + " ");
                if (currnode.left != null) {
                    q.add(currnode.left);
                }
                if (currnode.right != null) {
                    q.add(currnode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binary_tree tree = new binary_tree();
        node root = tree.build_tree(nodes);
        levelOrder(root);
    }

}

