// Given an integer array of nums and an integer window size X, 
// return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
// X size is always <= abs(i - j) where i and j are two distinct indices of array.

// Input Format:
// -------------
// Line-1: An integer N, Array Size
// Line-2: Space separated integers, array elements
// Line-3: An integer X, window size

// Output Format:
// --------------
// Line-1: Booelan value, true/false


// Sample Input-1:
// ---------------
// 4
// 1 2 3 1  
// 3 

// Sample Output-1: 
// ----------------
// false

// Sample Input-2:
// ---------------
// 6
// 1 2 3 3 2 3
// 2

// Sample Output-2: 
// ----------------
// true

import java.util.*;
public class DuplicateWindow{
    
    public static boolean fun(int[] arr,int n,int k)
    {
        boolean flag = true;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<k;i++)
        {
            if(set.add(arr[i]) == false)
            {
                return true;
            }
        }
        
        for(int i=k;i<n;i++)
        {
            
            set.remove(arr[i-k]);
            if(set.add(arr[i])== false)
            {
                return true;
            }
            
        }
        
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[]= new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]= sc.nextInt();
        }
        int k = sc.nextInt();
        
        System.out.println(fun(arr,n,k));
    }
}
