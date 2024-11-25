/**
  C# 공부 시작
  사용법 익히기
*/
public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[] {};
        if(arr.Length == 1) {
            return new int[] {-1};
        }
        int min = arr[0];
        for(int i=1; i<arr.Length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        answer = new int[arr.Length - 1];
        int j = 0;
        for(int i=0; i<arr.Length; i++) {
            if(arr[i] == min) {
                continue;
            }
            answer[j] = arr[i];
            j++;
        }
        return answer;
    }
}
