// You are given an integer array nums of length n and an integer target. 
// Your task is to find three integers in nums such that their sum is closest to the given target.

// Return the sum of these three integers.

// You may assume that each input would have exactly one solution.

// Input Format:
// -------------
// Line-1: An integer n, the size of the array.
// Line-2: n space-separated integers representing the elements of the array nums.
// Line-3: A single integer target.

// Output Format:
// --------------
// Line-1: Print a single integer, representing the sum of three integers closest to the target.

// Sample Input-1:
// ---------------
// 4
// -1 2 1 -4
// 1

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 3
// 0 0 0
// 1

// Sample Output-2:
// ----------------
// 0


import java.util.*;

public class ThreeSumClosest{
    
    
    public static int  fun(int n,int[] arr,int target)
    {
        
        int ans=99999;
        for(int i=0;i<n-1;i++)
        {
            int lft = i+1;
            int rt = n-1;
            
            
            while(lft< rt)
            {
                int sum =  arr[lft]+arr[rt]+arr[i];
                if(Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }
                
                if(arr[i]+arr[lft]+arr[rt] <target)
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
    
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int [] arr= new int[n];
        for(int i=0;i<n;i++)
        {
           arr[i] = sc.nextInt(); 
        }
        
        int target = sc.nextInt();
        Arrays.sort(arr);
        
        System.out.println(fun(n,arr,target));
        
    }
    
    
    
}