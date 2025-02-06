import java.util.Scanner;

public class Calories {

    public static int fun(int[] arr,int n,int k,int low,int high)
    {
        int points =0;
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        if(sum>high)
            {
                points++;
            }
            else if(sum<low){
                points--;
            }

        for(int i=k;i<n;i++)
        {
            sum+= arr[i]- arr[i-k];
            if(sum>high)
            {
                points++;
            }
            else if(sum<low){
                points--;
            }
        }
        return points;
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
        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(fun(arr,n,k,low,high));
    }
}
