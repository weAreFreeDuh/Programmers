class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int x = (numer1*denom2) + (numer2*denom1);
        int y = denom1 * denom2;
        int average = x >= y ? x : y;
        
        for(int i=2; i <= average; i++ ){
            if(x%i==0 && y%i==0){
                x = x/i;
                y = y/i;
                i--;
            }
        }
        
        return new int[]{x,y};
    }
}