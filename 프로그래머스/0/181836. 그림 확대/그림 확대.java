class Solution {
    public String[] solution(String[] picture, int k) {
        int len = picture.length;
        int xxx = len*k;
        String[] answer = new String[xxx];
        
        int index =0;
        for(String a : picture){
            String b = "";
            for(int i =0; i< a.length(); i++){
            int count = 1;
                while(count<=k){        
                    b = b + a.charAt(i);      
                    count++;
                }
            }    
            picture[index++] = b;
        }
        // for(int x= 0; x< len; x++){
        //     System.out.println(picture[x]);
        // }
        int index2 = 0;
        for(String tmp : picture){
            for(int j=0; j<k; j++){
                answer[index2] = tmp;   
                index2++;
            }
        }
        return answer;
    }
}