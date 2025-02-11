import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=num; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        int sum = 0;
        int[] dp = new int[num + 1];
        for(int i=1; i<=num; i++) {
            dp[i] = dp[i-1] + map.get(keySet.get(i-1));
        }
        
        for(int i=1; i<=num; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
        br.close();
    }
}
