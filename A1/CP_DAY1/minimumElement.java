// You are given an array consisting of N integers, and an integer, K. 
// Your task is to determine the minimum element in subarrays of size K.

// Sample Input1:
// --------------
// 5
// 10 12 14 11 15
// 3

// Sample Output1:
// ---------------
// 10 11 11

// Sample Input2:
// --------------
// 5
// 5 2 1 1 1
// 4

// Sample Output2:
// ---------------
// 1 1

import java.util.*;

public class minimumElement{
    public static void findMinInSubarrays(int[] arr, int n, int k) {
        for (int i = 0; i <= n - k; i++) {
            int minElement = arr[i];
            
           
            for (int j = i; j < i + k; j++) {
                if (arr[j] < minElement) {
                    minElement = arr[j];
                }
            }
            
            System.out.print(minElement + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
     
        
        findMinInSubarrays(arr, n, k);
    }
}
