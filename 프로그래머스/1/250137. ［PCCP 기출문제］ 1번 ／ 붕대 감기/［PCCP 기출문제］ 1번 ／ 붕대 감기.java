class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int len = attacks.length;
        int hp = health; // 현재 체력 
        int index = 0; // attacks 공격 시간
        int tmp = 0; // 시전 시간
        for(int i=1; i<=attacks[len-1][0]; i++){
            boolean attacked = false;
            
            // 공격 당했을 경우
            if(i == attacks[index][0]){
                attacked = true;
                hp -= attacks[index][1];
                index = index > len ? index : index+1;
                tmp = 0;
                if(hp <= 0) return -1;
            }
            // 공격이 아니고 회복 타이밍일 경우
            if(!attacked){
                hp += bandage[1];
            }
            // 시전 시간을 채웠을 경우
            if(tmp == bandage[0]){
                hp += bandage[2];
                tmp = 0;
            }
            // 최대 체력일 경우
            if(hp >= health){
                hp = health;
            }
            
            System.out.println(hp);
            tmp++;
        }
        
        return hp;
    }
}