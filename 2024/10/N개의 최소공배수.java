class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++) {
            answer = lcd(answer, arr[i]);
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    
    public int lcd(int a, int b) {
        return a * b / gcd(b, a%b);
    }
}
