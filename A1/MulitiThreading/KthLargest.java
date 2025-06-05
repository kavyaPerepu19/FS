import java.util.*;

class TreapNode {
    int data, priority, size;
    TreapNode left, right;

    TreapNode(int data) {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.size = 1;
        this.left = this.right = null;
    }
}

class KthLargest {
    static int count, kthLargestElement, k;

    private static void updateSize(TreapNode root) {
        if (root != null) {
            root.size = 1 + getSize(root.left) + getSize(root.right);
        }
    }

    private static int getSize(TreapNode node) {
        return (node == null) ? 0 : node.size;
    }

    public static TreapNode rotateLeft(TreapNode root) {
        if (root == null || root.right == null) return root;
        TreapNode y = root.right;
        TreapNode T2 = y.left;

        y.left = root;
        root.right = T2;

        updateSize(root);
        updateSize(y);
        return y;
    }

    public static TreapNode rotateRight(TreapNode root) {
        if (root == null || root.left == null) return root;
        TreapNode x = root.left;
        TreapNode T2 = x.right;

        x.right = root;
        root.left = T2;

        updateSize(root);
        updateSize(x);
        return x;
    }

    public static TreapNode insertNode(TreapNode root, int data) {
        if (root == null) return new TreapNode(data);

        if (data <= root.data) {
            root.left = insertNode(root.left, data);
            if (root.left != null && root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insertNode(root.right, data);
            if (root.right != null && root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }

        updateSize(root);
        return root;
    }

    public static void inorderReverse(TreapNode root) {
        if (root == null || count >= k) return;

        inorderReverse(root.right); // Visit right subtree first (largest values)

        count++; // Increment count
        if (count == k) {
            kthLargestElement = root.data;
            return;
        }

        inorderReverse(root.left); // Visit left subtree after root
    }

    public static void inorderPrint(TreapNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.println(root.data + " (Priority: " + root.priority + ", Size: " + root.size + ")");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        k = n - p + 1;

        TreapNode root = null;
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insertNode(root, value);
        }

        // Reset count and kthLargestElement before each search
        count = 0;
        kthLargestElement = -1;

        inorderReverse(root);
        System.out.println(kthLargestElement);
    }
}
