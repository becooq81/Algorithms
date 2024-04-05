class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (int i = 0; i < 4; i ++) {
            int nx = dx[i] + w;
            int ny = dy[i] + h;
            
            boolean isValid = nx >= 0 && nx < board.length && ny >= 0 && ny < board.length;
            
            if (isValid && board[ny][nx].equals(color)) {
                answer += 1;
            }
        }
        
        return answer;
    }
}