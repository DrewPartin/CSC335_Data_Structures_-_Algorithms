package Week3;

public class AVLTree {
    TreeNode root;

    public AVLTree() {
        this.root = null;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    private int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T = x.right;

        // Perform rotation
        x.right = y;
        y.left = T;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T = y.left;

        // Perform rotation
        y.left = x;
        x.right = T;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);
        else
            return root; // Duplicate values are not allowed

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Check balance factor
        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && val < root.left.val)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && val > root.right.val)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = {2, 1, 4, 5, 9, 3, 6, 7};
        for (int val : values) {
            tree.insert(val);
        }

        // Tree after insertion
        System.out.println("\nAVL Tree after insertion: ");
        for (int val : values) {
            System.out.print(val + " ");
        }

        // Inorder traversal of the AVL tree
        System.out.println("\n\nInorder traversal of the AVL tree: ");
        tree.inorderTraversal(tree.root);
        System.out.println("\n");
    }
}
