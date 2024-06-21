import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String st =  Integer.toString(n);
        for(int i = 0; i<st.length(); i++){
            answer +=Character.getNumericValue(st.charAt(i));
        }
        
        return answer;
    }
}