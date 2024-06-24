import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int index = 1;
        for(String st : privacies){
            
            String[] tmp = st.split(" ");
            
            int dateDiff = getDateDifference(tmp[0], today);
            int term = getTerms(terms,tmp[1]);
            
            if(dateDiff >= term) {
                System.out.println(index);
                answer.add(index);
            }
            index++;
            
        }
        int[] answers = answer.stream().mapToInt(Integer::intValue).toArray();
        return answers;
    }
    
    public static int getTerms(String[] terms, String privacie){
        for(String st : terms){
            String[] tmp = st.split(" ");
            if(tmp[0].equals(privacie)){
                return Integer.parseInt(tmp[1])*28;
            }
        }
        return 0;
    }
    
    public static int getDateDifference(String startDate, String endDate){
        String[] start = startDate.split("\\.");
        String[] end = endDate.split("\\.");
        
        return (Nu(end[0])-Nu(start[0]))*336+(Nu(end[1])-Nu(start[1]))*28+(Nu(end[2])-Nu(start[2]));
    }
    
    public static int Nu(String Date){
        return Integer.parseInt(Date);
    }
    
}