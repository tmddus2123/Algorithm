import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        if(topping.length <= 2) {
            return topping.length - 1;
        }
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        int[] arr1 = new int[topping.length - 1];
        int[] arr2 = new int[topping.length - 1];
        
        for(int i=0; i<topping.length - 1; i++) {
            set1.add(topping[i]);
            set2.add(topping[topping.length - 1 - i]);
            
            arr1[i] = set1.size();
            arr2[i] = set2.size();
        }
        
        for(int i=0; i<topping.length-1; i++) {
            if(arr1[i] == arr2[arr2.length - i - 1]) {
                answer++;
            }
        }
        return answer;
    }
}
