class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int skillTime = bandage[0];
        int recoverPerSec = bandage[1];
        int addRecover = bandage[2];
        
        int currentHealth = health;
        for (int i = 0; i < attacks.length; i ++) {
            int prev = 0;
            int focusedTime = 0;

            System.out.println(i+"th attack");
            if (i != 0) {
                prev = attacks[i-1][0];
            }
            focusedTime = (attacks[i][0] - prev - 1);
            currentHealth += focusedTime * recoverPerSec;
            
            int focusSuccess = focusedTime / skillTime;
            System.out.println("  연속 성공 횟수 " + focusSuccess);
            currentHealth += focusSuccess * addRecover;
            currentHealth = Math.min(health, currentHealth);
            System.out.println("  health till now "+currentHealth);
            
            currentHealth -= attacks[i][1];
            System.out.println("  health after attack "+currentHealth);

            
            if (currentHealth <= 0) {
                return -1;
            }
        }
        
        answer = currentHealth;
        
        return answer;
    }
}