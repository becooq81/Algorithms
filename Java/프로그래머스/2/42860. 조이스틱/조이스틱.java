class Solution {
    public int solution(String name) {
        int answer = 0;
                
        int charMoves = 0;
        for (int i =0; i < name.length(); i++) {
            int charMove = Math.min(name.charAt(i) - 'A', 26-(name.charAt(i) - 'A'));
            charMoves += charMove;
        }
        //System.out.println("Changes to be made: " + charMoves);
        answer += charMoves;
        int rightChanges = 0;
        int leftChanges = 0;
        
        for (int i =0; i < name.length(); i++) {
            int charMove = Math.min(name.charAt(i) - 'A', 26-(name.charAt(i) - 'A'));
            rightChanges += charMove;
            leftChanges += charMove;
            //System.out.println("Changes to be made: " + rightChanges+", "+leftChanges);
        }
        
        int idx = 0;
        int rightMoves = 0;
        while (rightChanges != 0) {
            
            int charMove = Math.min(name.charAt(idx) - 'A', 26-(name.charAt(idx) - 'A'));
            rightChanges -= charMove;
            if (rightChanges != 0) {
                rightMoves += 1;
            }
            idx += 1;
        }
        
        idx = 0;
        int leftMoves = 0;
        while (leftChanges != 0) {
            
            int charMove = Math.min(name.charAt(idx) - 'A', 26-(name.charAt(idx) - 'A'));
            leftChanges -= charMove;
            
            if (leftChanges != 0) {
                leftMoves += 1;
            }
            
            idx -= 1;
            if (idx < 0) {
                idx = name.length()-1;
            }
        }
        
        int minMoves = Math.min(leftMoves, rightMoves);
        int start = 0;
        int end = 0;
        idx = 0;
        
        while (idx < name.length()-1) {
            start = idx;
            end = idx;
            idx += 1;
            while (name.charAt(idx) == 'A' && idx < name.length()-1) {
                end += 1;
                idx += 1;
                int repeatStart = (start * 2) + (name.length()-end-1);
                int repeatEnd = (name.length()-end-1)*2 + (start);
                minMoves = Math.min(minMoves, repeatStart);
                minMoves = Math.min(minMoves, repeatEnd);
            }
        }
        //System.out.println(minMoves);
        answer += minMoves;
        
        //System.out.println("ANSWER: "+ Math.min(leftMoves, rightMoves));
        
        return answer;
    }
}