/**
  완전탐색으로 풀었더니 시간초과가 났다.
  stack을 사용해서 푸는 문제라고 하는데 어떻게 사용해야할지 감이 안잡혀서
  찾아봤더니 stack에 현재 인덱스 값을 넣는 거였다...
  어떻게 그런 사고력을 기를 수 있을까
*/
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        for(int i=1; i<numbers.length; i++) {
            while(!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
