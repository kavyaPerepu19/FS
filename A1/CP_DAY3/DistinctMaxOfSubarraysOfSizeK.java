import java.util.*;

public class DistinctMaxOfSubarraysOfSizeK{


    
    public static int fun(int[] arr, int n, int l){


        if (l > n) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxSum = 0, currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++){


            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            currentSum += arr[right];
            
            while (freq.get(arr[right]) > 1 || right - left + 1 > l){


                freq.put(arr[left], freq.get(arr[left]) - 1);
                currentSum -= arr[left];
                if (freq.get(arr[left]) == 0){


                    freq.remove(arr[left]);
                

                }
                left++;
            

            }
            
            if (right - left + 1 == l){


                maxSum = Math.max(maxSum, currentSum);
            

                }
        

        }
        
        return maxSum;
    

    }
    
    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){


            arr[i] = sc.nextInt();
        

        }
       
        
        int ans = fun(arr, n, l);
        System.out.println(ans);
    

    }

}