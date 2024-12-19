/**
  문제를 이해하는데 오래걸렸다. 사실 이해해도 어떻게 구현해야하는지 모르겠다..
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        int start = 0;
        while(num-- > 0) {
            int no = Integer.parseInt(br.readLine());
            if(no > start) {
                for(int i = start + 1; i <= no; i++) {
					stack.push(i);
					sb.append('+').append('\n');	// + 를 저장한다. 
				}
				start = no; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
      }

      // top에 있는 원소가 입력받은 값과 같이 않은 경우  
			else if(stack.peek() != no) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append('-').append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
