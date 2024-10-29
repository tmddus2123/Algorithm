/**
  테스트 케이스 여러가지 넣어봐도 다 맞는데 채점이 자꾸 틀려서 봤더니
  Integer 객체 비교할때 equals로 수정했더니 바로 통과..
*/

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(true) {
            for(int j=1; j<=n; j++) {
                map.put(j, (map.getOrDefault(j, j) + 1) / 2);
            }
            
            if(map.get(a).equals(map.get(b))) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
