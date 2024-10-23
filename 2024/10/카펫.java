/**
  [18, 6] -> [8, 3]과 [6,4] 두개의 배열이 나오지만
  직접 그려보면 8,3 의 경우 안에 채워지는 yellow 갯수가 동일하지만,
  6,4의 경우 안에 채워지는 yellow 갯수가 넘는다.

  따라서 카펫의 테두리 부분을 제외한 면적이 yellow의 갯수와 같아야한다
  (i-2)*(j-2) == yellow를 만족해야한다
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
              
        for(int i=(int)Math.sqrt(total); i<=total; i++) {
            for(int j=1; j<=i; j++) {
                if(i * j > total) {
                    break;
                }
                    
                if(i * j == total && (i-2)*(j-2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
