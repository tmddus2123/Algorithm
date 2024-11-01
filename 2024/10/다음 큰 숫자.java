// 첫번째 풀이
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = digit(n);
        
        while(true) {
            n++;
            if(count == digit(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
    
    public int digit(int num) {
        StringBuffer sb = new StringBuffer();
        while(num >= 2) {
            sb.append(num%2);
            num /= 2;
        }
        sb.append(num);
        String digitStr = sb.reverse().toString();
        
        int count = 0;
        for(int i=0; i<digitStr.length(); i++) {
            if(digitStr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}

// 두번째 풀이
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        
        while(true) {
            n++;
            if(count == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}

/*
문제대로 구현해서 정확성 테스트를 통과했지만 효울성에서 모두 실패,,,

찾아보니 Integer.bitCount(int n) 라는 함수가 존재한다 
*/
