class Solution {
    public int[] solution(long n) {
        String st = String.valueOf(n); 
        int[] answer = new int[st.length()];
        for(int i = 0; i< st.length(); i++){
            answer[st.length()-i-1] = Character.getNumericValue(st.charAt(i));
        }
        
        return answer;
    }
}