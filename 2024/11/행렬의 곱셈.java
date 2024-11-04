/**
  오랜만에 행렬문제 풀려니까 엄청 헷갈린다...

  arr1이 AxB 이고 arr2 CxD이면 B와 C가 같아야한다.
*/

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int rows1 = arr1.length;         // arr1의 행 개수
        int cols1 = arr1[0].length;      // arr1의 열 개수
        int cols2 = arr2[0].length;      // arr2의 열 개수 (arr1의 열 개수와 arr2의 행 개수가 같아야 곱셈 가능)

        // 결과 행렬 초기화
        int[][] answer = new int[rows1][cols2];

        // 행렬 곱셈 수행
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
