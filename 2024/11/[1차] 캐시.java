/**
  LRU(Least Recently Used) 알고리즘이 기억안나서 참고했다
  LRU 알고리즘 : 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법

  - cache hit일 경우 실행시간은 1이다.
  - cache miss일 경우 실행시간은 5이다.
*/
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new LinkedList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        List<String> caches = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            // cache miss
            if (!caches.contains(city)) {
                answer += 5;
                if (caches.size() >= cacheSize) {
                    caches.remove(0);
                }
                caches.add(city);
                continue;
            }
 
            // cache hit
            if (caches.contains(city)) {
                caches.remove(city);
                caches.add(city);
                answer += 1;
            }
        }
        return answer;
    }
}
