import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static String str;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        str = numbers;
        visited = new boolean[str.length()];
        
        for(int i=1; i<=str.length(); i++) {
            btk(0, i, new StringBuilder());
        }
        
        for(Integer i : set) {
            if(isValid(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    public static void btk(int depth, int n, StringBuilder sb) {
        if(sb.length() == n) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
            
        for(int i=0; i<str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                btk(depth + 1, n, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    public static boolean isValid(int num) {
        if(num <= 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
