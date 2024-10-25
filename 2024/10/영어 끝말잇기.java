/**
  나는 Stack으로 풀었지만
  HashSet으로도 풀 수 있다. Hashset이 더 빠르니까 HashSet을 사용하도록 하자
*/
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Stack<String> stack = new Stack<String>();
      
        for(int i=0; i<words.length; i++) {
            if(stack.isEmpty()) {
                stack.add(words[i]);
                continue;
            }
            
            String last = stack.peek();
            if(stack.contains(words[i]) || !(last.charAt(last.length() - 1) == words[i].charAt(0))) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
            stack.add(words[i]);
        }
        return answer;
    }
}
