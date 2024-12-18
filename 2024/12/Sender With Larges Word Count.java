/**
  LeetCode 처음 사용해봤는데 내 코드의 컴파일 속도, 메모리 사용량을 그래프로 보여줘서 좋다!

  내 코드가 괜찮은 코드인지 판단하기 쉬워서 당분간 LeetCode 애용할 것 같다.
*/
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<messages.length; i++) {
            int word = 1;
            for(int j=0; j<messages[i].length(); j++) {
                if(messages[i].charAt(j) == ' ') {
                    word++;
                }
            }
            map.put(senders[i], map.getOrDefault(senders[i], 0) + word);
        }
        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    return o2.compareTo(o1);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }   
        });
        return keySet.get(0);
    }
}
