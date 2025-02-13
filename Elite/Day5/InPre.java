// Construct the binary tree from the given In-order and Pre-order. 
// Find Nodes Between Two Levels in Spiral Order. 
//  The spiral order is as follows:
// -> Odd levels → Left to Right.
// -> Even levels → Right to Left.

// Input Format:
// --------------
// An integer N representing the number of nodes.
// A space-separated list of N integers representing the in-order traversal.
// A space-separated list of N integers representing the pre-order traversal.
// Two integers:
// Lower Level (L)
// Upper Level (U)

// Output Format:
// Print all nodes within the specified levels, but in spiral order.

// Example:
// Input:
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7
// 2 3

// Output:
// 3 2 4 5 6 7

// Explanation:
// Binary tree structure:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Levels 2 to 3 in Regular Order:
// L evel 2 → 2 3
// Level 3 → 4 5 6 7

// Spiral Order:
// Level 2 (Even) → 3 2 (Right to Left)
// Level 3 (Odd) → 4 5 6 7 (Left to Right)


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
    public static int preIndex;
    public static Node buildTree(int preOrder[],int start,int end,Map<Integer,Integer> m){
        if(start>end || preIndex>=preOrder.length){
            return null;
        }
        int idx = m.get(preOrder[preIndex]);
        Node root = new Node(preOrder[preIndex]);
        preIndex++;
        root.left = buildTree(preOrder,start,idx-1,m);
        root.right = buildTree(preOrder,idx+1,end,m);
        return root;
    }
    
    
    public static List<List<Integer>> levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        if(root==null){
            return levels;
        }
        q.add(root);
        int idx = 0;
        while(!q.isEmpty())
        {
            List<Integer> li = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                Node curr = q.poll();
                li.add(curr.data);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            if(idx%2==0){
                levels.add(li);
            }
            else{
                Collections.reverse(li);
                levels.add(li);
            }
            idx++;
        }
        return levels;
    }
    
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inOrder[] = new int[n];
        int preOrder[] = new int[n];
        for(int i=0;i<n;i++)
        {
            inOrder[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            preOrder[i] = sc.nextInt();
        }
        int l = sc.nextInt();
        int u = sc.nextInt();;
        
        preIndex = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            m.put(inOrder[i],i);
        }
        Node root = buildTree(preOrder,0,n-1,m);
        
        List<List<Integer>> ans = levelOrder(root);
        // System.out.println(ans);
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=l;i<=u;i++){
            al.addAll(ans.get(i-1));
        }
        System.out.println(al);
        }
    }