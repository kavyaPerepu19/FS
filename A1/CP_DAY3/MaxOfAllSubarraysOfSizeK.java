import java.util.*;
public class MaxOfAllSubarraysOfSizeK{
    
    public static void fun(int[] arr,int n,int k)
    {
        ArrayList<Integer>li = new ArrayList<>();
       
        for(int i=0;i<=n-k;i++)
        {
            int maxi = -99;
            for(int j=i;j<i+k;j++)
            {
                maxi = Math.max(maxi,arr[j]);
            }
            
            li.add(maxi);
        }
        
        for(int i=0;i<li.size();i++)
        {
            if(i!=li.size()-1)
            {
                System.out.print(li.get(i)+" ");
            }
            else{
                System.out.println(li.get(i));
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        fun(arr,n,k);
        
    }
}