// A string is good if there are no repeated characters.
// Given a string s, return the number of good substrings of length three in s.
// Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
// A substring is a contiguous sequence of characters in a string.

// Sample Input-1:
// ---------------
// xyzzaz

// Sample Output-1:
// ----------------
// 1

// Explanation: 
// ------------
// There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
// The only good substring of length 3 is "xyz".

// Sample Input-2:
// ---------------
// aababcabc

// Sample Output-2:
// ----------------
// 4

// Explanation: 
// ------------
// There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
// The good substrings are "abc", "bca", "cab", and "abc".

package A1.CP_DAY4;

import java.util.*;
public class GoodStrings{
    
    public static int fun(String s)
    {
       int count = 0;
        for (int i = 0; i < s.length() - 2; i++) { 
            String sub = s.substring(i, i + 3);
            if (sub.chars().distinct().count() == 3) { 
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        System.out.println(fun(str));
    }
}
