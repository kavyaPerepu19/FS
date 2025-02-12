// 

import java.util.*;
public class RotateArray{
    
    public static void  reverse(int[] arr,int start,int end)
    {
        int i=start;
        int j= end;
        while(i<j)
        {
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            i++;
            j--;
            
        }
        
    }
    
    public static void  rotate(int[] arr,int n,int k)
    {
        
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        
        int k = sc.nextInt();
        k=k%n;
        
        rotate(arr,n,k);
        
        for(int i=0;i<n;i++)
        {
            if(i!=n-1)
            {
                System.out.print(arr[i]+" ");
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }
}