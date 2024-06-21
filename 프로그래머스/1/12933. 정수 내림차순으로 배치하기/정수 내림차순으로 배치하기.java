import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String ans = "";
        
        String[] st = String.valueOf(n).split("");
        System.out.println(Arrays.toString(st));
        //System.out.println(Arrays.toString(st));
        for(int i = 0; i < st.length-1; i ++){
            for(int j= i+1; j < st.length; j++){
                if( Integer.parseInt(st[i]) < Integer.parseInt(st[j]) ){
                    String tmp = st[i];
                    st[i] = st[j];
                    st[j] = tmp;
                }
            }
        }
        for(int z = 0; z<st.length; z++){
             ans += st[z];
        }
        
        
        return Long.parseLong(ans);
    }
}