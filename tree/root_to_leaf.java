package tree;

import java.util.ArrayList;

public class root_to_leaf {
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

    public static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void printPath(ArrayList <Integer> path){
        for(int i = 0; i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }


    public static void printRootToLeaf(node root,ArrayList<Integer> path){
if(root == null){
    return;
}

        path.add(root.data);

        //leaf node
        if(root.left == null && root.right == null){
            printPath( path);
        }
        else{ // non-leaf node
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }
        path.remove(path.size()-1); // deleting last index in arraylist

    }
    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        
        printRootToLeaf(root, new ArrayList<>());
    }
    
}
