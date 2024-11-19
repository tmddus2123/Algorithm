import java.util.*;

class Solution {
    public int[] solution(String s) {
        String num = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == ',') {
                if(num != "") {
                    map.put(Integer.parseInt(num), map.getOrDefault(Integer.parseInt(num), 0) + 1);
                    num = "";
                }
            } else {
                num = num + s.charAt(i);   
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int[] answer = new int[map.size()];
        int i=0;
        for(int v : list) {
            answer[i] = v;
            i++;
        }
        return answer;
    }
}
