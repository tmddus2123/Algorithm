class Solution {
    static int cnt = 0;
    static int deleteCount = 0;
    public int[] solution(String s) {
        change(s);
        int[] answer = {cnt, deleteCount};
        return answer;
    }
    public static void change(String cur){
        if(cur.equals("1")) return;
        cnt++;
        int cnt1 = 0; // 0의 개수 
        int cnt2 = 0; // 1의 개수 
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == '0') cnt1++;
            else cnt2++;
        }
        deleteCount += cnt1;
        change(toBinary(cnt2));
    }
    public static String toBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n >= 2){
            sb.append(n % 2);
            n /= 2;
        }
        sb.append(n);
        return sb.reverse().toString();
    }
}
