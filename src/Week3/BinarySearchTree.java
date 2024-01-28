package Week3;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    public int nodeLevel(int value) {
        return nodeLevel(root, value, 1); // Start from level 1
    }

    private int nodeLevel(TreeNode root, int value, int level) {
        if (root == null)
            return 0; // Node not found

        if (value == root.val)
            return level;

        int leftLevel = nodeLevel(root.left, value, level + 1);
        if (leftLevel != 0)
            return leftLevel; // Node found in the left subtree

        int rightLevel = nodeLevel(root.right, value, level + 1);
        return rightLevel; // Node found in the right subtree (or not found at all)
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val)
            root.left = deleteRec(root.left, key);
        else if (key > root.val)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public static boolean compare(BinarySearchTree tree, int[] arr) {
        // Check if the size of the tree and the array are the same
        if (tree.size(tree.root) != arr.length) return false;

        // Check if the tree contains all the values in the array
        for (int val : arr) {
            if (!tree.contains(tree.root, val)) return false;
        }

        return true;
    }

    public boolean contains(TreeNode root, int value) {
        if (root == null) return false;
        if (root.val == value) return true;
        return contains(root.left, value) || contains(root.right, value);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {3, 1, 4, 6, 9, 2, 5, 7};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("\nTree after insertion: ");
         for (int val : values) {
             System.out.print(val + " ");
         }
         System.out.println("\n");

        // Delete root node
        tree.delete(tree.root.val);

        System.out.println("Tree after deleting root: ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println("\n");

        // Test nodeLevel function
        System.out.println("Level of node with value 5: " + tree.nodeLevel(5));
        System.out.println("Level of node with value 9: " + tree.nodeLevel(9));
        System.out.println("Level of node with value 8: " + tree.nodeLevel(8) + "\n"); // Not in tree

        // Inorder traversal of the tree
        System.out.println("Inorder traversal of the given tree:");
        tree.inorderTraversal(tree.root);
        System.out.println("\n");

        // Test size function
        System.out.println("Size of the tree: " + tree.size(tree.root) + "\n");

        // Test contains function
        System.out.println("Tree contains 5: " + tree.contains(tree.root, 5));
        System.out.println("Tree contains 9: " + tree.contains(tree.root, 9));
        System.out.println("Tree contains 8: " + tree.contains(tree.root, 8) + "\n");

        // Test compare function
        // Array contains original root node, expect false
        int[] arr = {3, 1, 4, 6, 9, 2, 5, 7};
        System.out.println("Compare tree with array: " + compare(tree, arr) + "\n");

        // Array does not contain original root node, expect true
        int[] arr2 = {1, 4, 6, 9, 2, 5, 7};
        System.out.println("Compare tree with array: " + compare(tree, arr2) + "\n");
    }
}
