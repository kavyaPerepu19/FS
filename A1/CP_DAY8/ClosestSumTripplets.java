// You are given three sorted integer arrays A[], B[], and C[], and an integer target.

// Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

// If there is no exact match, return the triplet with the minimum absolute difference to the target.

// Input Format:
// -------------
// Line 1: An integer N, the size of the first array.
// Line 2: N space-separated integers representing elements of array A.
// Line 3: An integer M, the size of the second array.
// Line 4: M space-separated integers representing elements of array B.
// Line 5: An integer P, the size of the third array.
// Line 6: P space-separated integers representing elements of array C.
// Line 7: An integer target, the required sum.

// Output Format:
// --------------
// Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

// Constraints:
// ------------
// Time Complexity: O(N + M + P)
// Space Complexity: O(1)

// Sample Input-1:
// ---------------
// 4
// 5 10 20 30
// 4
// 1 3 7 10
// 4
// 2 5 8 12
// 25

// Sample Output-1:
// ----------------
// 10 3 12

// Explanation:
// -------------
// The sum 10 + 7 + 8 = 25, which exactly matches target.


// Sample Input-2:
// ---------------
// 3
// 1 5 10
// 3
// 3 6 9
// 3
// 4 7 8
// 30

// Sample Output-2:
// ----------------
// 10 9 8

// Explanation:
// ------------
// The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3).

import java.util.*;
public class ClosestSumTripplets{
    
    public static int[] fun(int[] arr1,int arr2[],int arr3[],int n1,int n2,int n3,int target)
    {
        int[] ans= new int[3];
        ans[0]=-1;
        ans[1]=-1;
        ans[2] =-1;
        
        int mini=999999;
        
        for(int i=0;i<n1;i++)
        {
            int lft=0;
            int rt = n3-1;
            
            while(lft< n2 && rt>=0){
                
                if( Math.abs(arr2[lft]+arr3[rt]+arr1[i] - target) < Math.abs(mini-target) )
                {
                    mini=arr2[lft]+arr3[rt]+arr1[i];
                    ans[0] =arr1[i];
                    ans[1]=arr2[lft];
                    ans[2] = arr3[rt];
                }
                
                if(arr2[lft]+arr3[rt]+arr1[i] < target )
                {
                    lft++;
                }
                else{
                    rt--;
                }
                
            }
        }
        
        return ans;
    }
    
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt();
        int arr1[] = new int[n1];
        for(int i=0;i<n1;i++)
        {
            arr1[i] = sc.nextInt();
        }
        
        int n2= sc.nextInt();
        int arr2[] = new int[n2];
        for(int i=0;i<n2;i++)
        {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr2);
        
        int n3= sc.nextInt();
        int arr3[] = new int[n3];
        for(int i=0;i<n3;i++)
        {
            arr3[i] = sc.nextInt();
        }
        Arrays.sort(arr3);
        int target = sc.nextInt();
        
        System.out.println( Arrays.toString( fun(arr1,arr2,arr3,n1,n2,n3,target ) ) );
    }
}