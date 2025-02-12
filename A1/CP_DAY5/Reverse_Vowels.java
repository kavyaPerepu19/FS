// Given a string s, reverse only all the vowels in the 
// string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
// appear in both lower and upper cases, more than once.

// Sample Input-1:
// ---------------
// hello

// Sample Output-1:
// ----------------
// holle

// Sample Input-2:
// ----------------
// Keshavmemorial

// Sample Output-2:
// ----------------
// Kashivmomerael


import java.util.*;

public class Reverse_Vowels 

{  
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String str){
        char[] arr = str.toCharArray();
        int low = 0, high = arr.length - 1;
        while (low < high){
            while (low < high && !vowels.contains(arr[low])){
                low++;
            }
            while (low < high && !vowels.contains(arr[high])) {
                high--;
            }
            
            if (low < high){


                char temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        

        }
        
        return new String(arr);
    

    }

    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  
        System.out.println(reverseVowels(str));
        sc.close();
    

    }

}
