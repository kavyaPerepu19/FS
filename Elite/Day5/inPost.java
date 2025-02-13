// Given the in-order and post-order traversals of a binary tree, construct 
// the original binary tree. For the given Q number of queries, 
// each query consists of a lower level and an upper level. 
// The output should list the nodes in the order they appear in a level-wise.

// Input Format:
// -------------
// An integer N representing the number nodes.
// A space-separated list of N integers representing the similar to in-order traversal.
// A space-separated list of N integers representing the similar to post-order traversal.
// An integer Q representing the number of queries.
// Q pairs of integers, each representing a query in the form:
// Lower level (L)
// Upper level (U)

// Output Format:
// For each query, print the nodes in order within the given depth range

// Example
// Input:
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// 2
// 1 2
// 2 3
// Output:
// [1, 2, 3]
// [2, 3, 4, 5, 6, 7]

// Explanation:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// Query 1 (Levels 1 to 2): 1 2 3
// Query 2 (Levels 2 to 3): 2 3 4 5 6 7

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
        left = null;
        right = null;
    }
}

class Test{
    public static int postIndex;
    public static Node buildTree(int[] postOrder,int start,int end,Map<Integer,Integer> m,int i){
        if(start>end || postIndex<0){
            return null;
        }
        int idx = m.get(postOrder[postIndex]);
        Node root = new Node(postOrder[postIndex--]);
        root.right = buildTree(postOrder,idx+1,end,m,i);
        root.left = buildTree(postOrder,start,idx-1,m,i);
        return root;
    }
    
    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                Node curr = q.poll();
                li.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            levels.add(li);
        }
        return levels;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inOrder[] = new int[n];
        int postOrder[] = new int[n];
        for(int i=0;i<n;i++){
            inOrder[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            postOrder[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int l[] = new int[q];
        int u[] = new int[q];
        for(int i=0;i<q;i++){
            l[i] = sc.nextInt();
            u[i] = sc.nextInt();
        }
        postIndex = n-1;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(inOrder[i],i);
        }
        Node root = buildTree(postOrder,0,n-1,m,n-1);
        
        List<List<Integer>> ans = levelOrder(root);
        // System.out.println(ans);
        
        for(int i=0;i<q;i++){
            int start = l[i];
            int end = u[i];
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=start;j<=end;j++){
                al.addAll(ans.get(j-1));
            }
            System.out.println(al);
        }
    }
    
    
}