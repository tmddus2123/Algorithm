/**
  덱(데크)는 Double-Ended Queue의 줄임말로 큐의 양쪽으로 엘리먼트의 삽입과 삭제를 수행할 수 있는 자료구조이다.

  앞쪽 삽입              뒷쪽 삽입                   앞쪽 제거            뒷쪽제거
  addFirst()            addLast()                   remove()            removeLast()
  offerFirst()          add()                       removeFirst()       pollLast()
  push()                offerLast()                 poll()              
                        offer()                     pollFirst()
                                                    pop()
  앞쪽 참조              뒷쪽 참조
  getFirst()            getLast()
  peek()                peekLast()
  peekFirst()
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> stack = new ArrayDeque<>();
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int n = 0;
            
            switch (order) {
                case "push_front":
                    n = Integer.parseInt(st.nextToken());
                    stack.addFirst(n);
                    break;
                    
                case "push_back":
                    n = Integer.parseInt(st.nextToken());
                    stack.add(n);
                    break;

                case "pop_front":
                    if(stack.size() >= 1) {
                        bw.write(stack.poll() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                    
                case "pop_back":
                    if(stack.size() >= 1) {
                        bw.write(stack.pollLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;

                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.size() >= 1) {
                        bw.write("0\n");
                    } else {
                        bw.write("1\n");
                    }
                    break;
                    
                case "front":
                    if(stack.size() >= 1) {
                        bw.write(stack.peek() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                    
                case "back":
                    if(stack.size() >= 1) {
                        bw.write(stack.peekLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
