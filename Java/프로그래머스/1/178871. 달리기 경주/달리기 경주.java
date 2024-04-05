import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> playersRanks = new HashMap<>();
        Map<Integer, String> ranksPlayers = new HashMap<>();
        
        for (int i = 0; i < players.length; i ++) {
            playersRanks.put(players[i], i+1);
            ranksPlayers.put(i+1, players[i]);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String passerPlayer = callings[i];
            int calledRank = playersRanks.get(passerPlayer);
            int passedRank = calledRank-1;
            String passedPlayer = ranksPlayers.get(passedRank);
            
            playersRanks.put(passerPlayer, passedRank);
            playersRanks.put(passedPlayer, calledRank);
            
            ranksPlayers.put(passedRank, passerPlayer);
            ranksPlayers.put(calledRank, passedPlayer);
        }
        
        Map<Integer, String> sortedMap = new TreeMap<>(ranksPlayers);
        int idx = 0;
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            answer[idx] = entry.getValue();
            idx += 1;
        }
        
        return answer;
    }
}