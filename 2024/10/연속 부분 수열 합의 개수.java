/**
  3중첩을 머리로만 풀려니까 자꾸 헷갈린다..
*/

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++) {
            for(int j=0; j<=elements.length; j++) {
                int sum = 0;
                for(int k=j; k<j+i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
