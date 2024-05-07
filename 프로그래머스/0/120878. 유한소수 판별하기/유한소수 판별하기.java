class Solution {
    public int solution(int a, int b) {
        for(int i = 2; i < 1000; i++){
            if(a%i==0 && b%i==0){
                a = a/i;
                b = b/i;
                i--;
            }   
        }
        
        while (b%2 == 0) b = b/2;
        while (b%5 == 0) b = b/5;
        
        return b == 1 ? 1 : 2;
    }
}