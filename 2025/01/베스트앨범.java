import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> p = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            p.put(i, plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        List<Integer> keySet1 = new ArrayList<>(p.keySet());
        keySet1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(p.get(o1) == p.get(o2)) {
                    return o1.compareTo(o2);
                }
                return p.get(o2).compareTo(p.get(o1));
            }
        });
      
        List<Integer> list = new ArrayList<>();
        for(String key : keySet) {
            int i = 0;
            for(Integer num : keySet1) {
                if(i == 2) {
                    break;
                }
                
                if(genres[num].equals(key)) {
                    list.add(num);
                    i++;
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
