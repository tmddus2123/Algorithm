import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        answer = citations.length;
        for(int c : citations) {
            if(c >= answer) {
                break;
            } else {
                answer--;
            }
        }
        return answer;
    }
}
