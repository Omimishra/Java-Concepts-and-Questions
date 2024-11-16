package tree;

public class print_in_range {
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
public static void print(node root, int X , int Y){
    if(root == null){
        return;
    }

    if (root.data >= X && root.data <= Y ){
        print(root.left, X, Y);
        System.out.print(root.data+" ");
        print(root.right, X, Y);
    }
else if (root.data >= Y){
    print(root.left, X, Y);
}
else{
    print(root.right, X, Y);
}


}
    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        print(root, 6, 10);
    }

}
