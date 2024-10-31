/**
  HashSet으로 풀 수 있을것같은 느낌으 들었지만 실패했다.
  괄호는 순서가 중요하다보니 HashSet은 순서 보장이 안되니 비효율적이다.
*/
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String origin = s;
      
        for (int i = 0; i < s.length(); i++) {
            s = origin.substring(i) + origin.substring(0, i);

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char open = stack.pop();
                    if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && isValid) {
                answer++;
            }
        }
        return answer;
    }
}
