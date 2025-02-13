// Construct Tree from the given Level-order and In-order.
// Compute the Depth and Sum of the Deepest nodes in the Binary tree

// Input Format:
// -------------
// An integer N representing the number of nodes.
// A space-separated list of N integers representing the in-order traversal.
// A space-separated list of N integers representing the level-order traversal.

// Output Format:
// --------------
// Print two values:
// ->The maximum number of levels.
// ->The sum of all node values at the deepest level.

// Example:
// -------------
// Input:
// 11
// 7 8 4 2 5 9 11 10 1 6 3
// 1 2 3 4 5 6 7 9 8 10 11

// Output:
// 6 11

// Explanation:
// The binary tree structure:
//            1
//          /   \
//        2       3
//       / \     /
//      4   5   6
//     /     \   
//    7       9
//     \       \
//      8      10
//             /
//           11
// Maximum Depth: 6
// nodes at the Deepest Level (6): 11
// Sum of nodes at Level 6: 11


import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
        right = left = null;
    }
}

class Test{
    public static int minIndex(Map<Integer,Integer> mp,int inOrder[],int start,int end){
        int index = start;
        for(int i=start;i<=end;i++){
            if(mp.get(inOrder[i])<mp.get(inOrder[index])){
                index = i;
            }
        }
        return index;
    }
    
    public static Node buildTree(int inOrder[],Map<Integer,Integer> mp,int start,int end){
        if(start>end){
            return null;
        }
        int idx = minIndex(mp,inOrder,start,end);
        Node root = new Node(inOrder[idx]);
        if(start==end){
            return root;
        }
        root.left = buildTree(inOrder,mp,start,idx-1);
        root.right = buildTree(inOrder,mp,idx+1,end);
        return root;
    }
    
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root==null){
            return levels;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                li.add(curr.data);
            }
            levels.add(li);
        }
        return levels;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inOrder[] = new int[n];
        int level[] = new int[n];
        for(int i=0;i<n;i++){
            inOrder[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            level[i] = sc.nextInt();
        }
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(level[i],i);
        }
        Node root = buildTree(inOrder,mp,0,n-1);
        List<List<Integer>> levels = levelOrder(root);
        // System.out.println(levels);
        int sum = 0;
        List<Integer> lastLevel = levels.get(levels.size()-1);
        for(int i:lastLevel){
            sum+=i;
        }
        System.out.println(levels.size()+" "+sum);
    }
}