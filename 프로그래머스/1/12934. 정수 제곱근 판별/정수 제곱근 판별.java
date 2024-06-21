class Solution {
    public long solution(long n) {
        long answer = 0;
        for(long i = 1; i <= n; i++){
            if(i*i==n) {
                return (i+1)*(i+1);
            }
            else if(i*i>n) {
                return -1;
            }
        }
        
        return answer;
    }
}