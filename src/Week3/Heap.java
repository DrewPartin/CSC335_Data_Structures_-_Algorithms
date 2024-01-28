package Week3;

import java.util.List;
import java.util.Vector;

public class Heap {

    private Vector<Integer> heap;
    private TreeNode root;

//    public Heap() {
//        this.root = null;
//    }

    public Heap() {
        this.heap = new Vector<>();
    }

    public void heapify() {
        int n = heap.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(i, n);
        }
    }

    private void heapifyDown(int index, int heapSize) {
        int largestIdx = index;
        int leftChildIdx = 2 * index + 1;
        int rightChildIdx = 2 * index + 2;

        if (leftChildIdx < heapSize && heap.get(leftChildIdx) > heap.get(largestIdx)) {
            largestIdx = leftChildIdx;
        }

        if (rightChildIdx < heapSize && heap.get(rightChildIdx) > heap.get(largestIdx)) {
            largestIdx = rightChildIdx;
        }

        if (largestIdx != index) {
            swap(index, largestIdx);
            heapifyDown(largestIdx, heapSize);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public List<Integer> getHeap() {
        return heap;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (root.left == null) {
            root.left = insertRec(root.left, value);
        } else if (root.right == null) {
            root.right = insertRec(root.right, value);
        } else {
            // If both left and right child are present, recursively insert into left subtree
            root.left = insertRec(root.left, value);
        }

        return root;
    }

    public int heapRemove() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty");
        }

        int removedValue = root.val;
        // Find the deepest node
        TreeNode deepestNode = findDeepestNode();
        // Copy the value of the deepest node to the root
        root.val = deepestNode.val;
        // Remove the deepest node
        removeDeepestNode();
        return removedValue;
    }

    private TreeNode findDeepestNode() {
        TreeNode temp = root;
        TreeNode deepestNode = null;
        while (temp != null) {
            deepestNode = temp;
            if (temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return deepestNode;
    }

    private void removeDeepestNode() {
        TreeNode temp = root;
        TreeNode parentOfDeepest = null;
        while (temp != null && (temp.left != null || temp.right != null)) {
            parentOfDeepest = temp;
            if (temp.left != null) {
                if (temp.right == null) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            } else {
                temp = temp.right;
            }
        }
        // Remove the deepest node
        if (parentOfDeepest.left == temp) {
            parentOfDeepest.left = null;
        } else {
            parentOfDeepest.right = null;
        }
    }

    public static void main(String[] args) {
//        Heap heap = new Heap();
//        int[] values = {3, 1, 4, 6, 9, 2, 5, 7};
//        for (int val : values) {
//            heap.insert(val);
//        }
//
//        int removedValue = heap.heapRemove();
//        System.out.println("\nRemoved value: " + removedValue + "\n");

        Heap heap = new Heap();
        int[] values = {6, 1, 4, 5, 9, 3, 2, 7};
        for (int val : values) {
            heap.getHeap().add(val);
        }

        System.out.println("\nHeap before heapify: " + heap.getHeap());
        heap.heapify();
        System.out.println("\nHeap after heapify: " + heap.getHeap() + "\n");
    }
}
