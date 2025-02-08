import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        String[][] result = new String[record.length][2];
        
        int cnt = 0;
        for(String line : record) {
            String[] info = line.split(" ");
            
            if(info[0].equals("Enter")) {
                user.put(info[1], info[2]);
                result[cnt][0] = info[0];
                result[cnt][1] = info[1];
                cnt++;
            } else if(info[0].equals("Leave")) {
                result[cnt][0] = info[0];
                result[cnt][1] = info[1];
                cnt++;
            } else {
                user.put(info[1], info[2]);
            }               
        }
        String[] answer = new String[cnt];

        for(int i=0; i<cnt; i++) {
            StringBuilder sb = new StringBuilder();
            
            sb.append(user.get(result[i][1]) + "님이 ");
            if(result[i][0].equals("Enter")) {
                sb.append("들어왔습니다.");
            } else {
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
