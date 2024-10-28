/**
  Map에 getOrDefault(a, b) 함수가 존재
  
  Comparator 재정의 하는건 맨날 까먹는다..
*/

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for (Integer key : keySet) {
            k -= map.get(key);
            answer++;
            
            if(k <= 0) {
                break;
            }
        }
        return answer;
    }
}
