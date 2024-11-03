import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0; i<discount.length - 9; i++) {
            HashMap<String, Integer> map = new HashMap<>();
          
            for(int j=i; j<10 + i; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            boolean result = true;
            for(int j=0; j<want.length; j++) {
                if(!map.containsKey(want[j]) || map.get(want[j]) < number[j]) {
                    result = false;
                    break;
                }
            }
            if(result) {
                answer++;
            }
        }
        return answer;
    }
}
