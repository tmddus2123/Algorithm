/**
  괴롭다 괴로워!
  언제쯤 정렬 구현에 익숙해질까
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dict = new HashMap<>();
        for(int i=0; i<num; i++) {
            String word = br.readLine();
            if(word.length() >= length) {
                dict.put(word, dict.getOrDefault(word, 0) + 1);
            }
        }
        List<String> keySet = new ArrayList<>(dict.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(dict.get(o1) == dict.get(o2)) {
                    if(o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else {
                        return o2.length() - o1.length();
                    }
                } else {
                    return dict.get(o2) - dict.get(o1);
                }
            }
        });
         for(String str : keySet) {
            sb.append(str + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}
