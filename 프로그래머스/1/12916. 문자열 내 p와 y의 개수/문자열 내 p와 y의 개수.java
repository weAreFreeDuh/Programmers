class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int pNum = 0;
        int yNum = 0;

        for(int i = 0; i<s.length();i++){
            System.out.println(s.charAt(i));
            if(s.charAt(i)=='p' || s.charAt(i)=='P') pNum++;
            if(s.charAt(i)=='y' || s.charAt(i)=='Y') yNum++;
        }
        
        if(pNum == yNum) answer = true;
        return answer;
    }
}