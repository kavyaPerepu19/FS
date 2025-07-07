import java.util.*;
class Main{
    public static void main(String[] args) {
        List<String> li = Arrays.asList("India","Australia","USA","Singapore","UK","Indian Ocean","Russia");

        System.out.println(li.stream()
        .filter(ele->ele.length()>4)
        .sorted()

        
        .limit(2)
        .toList());
    }
}