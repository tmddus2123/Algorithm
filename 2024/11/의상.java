/**
  방정식을 찾으면 쉽게 풀 수 있는 문제인데 어떻게 찾아야하는지는 더 공부해야한다..
  옷의 경우의 수가 a + b + c + ab + bc + abc 라서 정말 이대로 구현하려다가 아닌 것 같아서 봤더니

  (a + 1) * (b + 1) * (c + 1) - 1 라는 방정식이 나온다고 한다.
  조합을 잊지 않았으면 찾아낼 수 있었을 것 같다..
*/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(Integer cnt : map.values()) {
            answer *= (cnt + 1);
        }
        return answer-1;
    }
}
