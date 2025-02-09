// Write a program to construct a binary tree from level-order input, while treating -1 
// as a placeholder for missing nodes. The program reads input, constructs the tree, 
// and provides an in-order traversal to verify correctness.

// Input Format:
// ---------------
// Space separated integers, level order data (where -1 indiactes null node).

// Output Format:
// -----------------
// Print the in-order data of the tree.


// Sample Input:
// ----------------
// 1 2 3 -1 -1 4 5

// Sample Output:
// ----------------
// 2 1 4 3 5

// Explanation:
// --------------
//     1
//    / \
//   2   3
//      / \
//     4   5


// Sample Input:
// ----------------
// 1 2 3 4 5 6 7

// Sample Output:
// ----------------
// 4 2 5 1 6 3 7

// Explanation:
// --------------
//         1
//        / \
//       2   3
//      / \  / \
//     4  5 6  7


import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Test{
    public static void buildTree(Node root,int val){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left==null && curr.data!=-1){
                curr.left = new Node(val);
                return;
            }
            else if(curr.left!=null && curr.left.data!=-1){
                q.add(curr.left);
            }
            if(curr.right==null && curr.data!=-1){
                curr.right = new Node(val);
                return;
            }
            else if(curr.right!=null && curr.right.data!=-1){
                q.add(curr.right);
            }
        }
    }
    
    public static List<Integer> res = new ArrayList<>();
    
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(root.data!=-1){
            res.add(root.data);
        }
        inOrder(root.right);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        Node root = new Node(Integer.parseInt(arr[0]));
        for(int i=1;i<arr.length;i++){
            buildTree(root,Integer.parseInt(arr[i]));
        }
        
        inOrder(root);
        
        System.out.println(res);
    }
}