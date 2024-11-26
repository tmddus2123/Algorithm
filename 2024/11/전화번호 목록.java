/**
  String배열을 정렬할 땐 사전순으로 정렬되기 때문에
  정렬 후 for문 한 번으로 앞뒤 체크만 하면된다.
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        Arrays.sort(phone_book);
        
        for(int i=0;i<phone_book.length-1; i++) {
            if(phone_book[i].startsWith(phone_book[i+1]) || phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
