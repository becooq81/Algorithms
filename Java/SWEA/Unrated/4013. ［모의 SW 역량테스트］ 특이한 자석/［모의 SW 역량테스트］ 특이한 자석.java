import java.util.*;
import java.io.*;

public class Solution {

    public static void rotate(int[][] magnets, int index, int direction) {
        if (direction == 1) { 
            int temp = magnets[index][7];
            for (int i = 7; i > 0; i--) {
                magnets[index][i] = magnets[index][i - 1];
            }
            magnets[index][0] = temp;
        } else {
            int temp = magnets[index][0];
            for (int i = 0; i < 7; i++) {
                magnets[index][i] = magnets[index][i + 1];
            }
            magnets[index][7] = temp;
        }
    }

    public static void propagateRotations(int[][] magnets, int index, int direction) {
        int[] rotations = new int[4];
        rotations[index] = direction;

        for (int i = index; i > 0; i--) {
            if (magnets[i][6] != magnets[i - 1][2]) { 
                rotations[i - 1] = -rotations[i]; 
            } else {
                break;
            }
        }

        for (int i = index; i < 3; i++) {
            if (magnets[i][2] != magnets[i + 1][6]) {
                rotations[i + 1] = -rotations[i]; 
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rotations[i] != 0) {
                rotate(magnets, i, rotations[i]);
            }
        }
    }

    public static int calculateScore(int[][] magnets) {
        int score = 0;
        int[] scores = {1, 2, 4, 8}; 

        for (int i = 0; i < 4; i++) {
            if (magnets[i][0] == 1) {
                score += scores[i];
            }
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(reader.readLine());
            int[][] magnets = new int[4][8];

            for (int i = 0; i < 4; i++) {
                String[] inputs = reader.readLine().split(" ");
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            for (int i = 0; i < K; i++) {
                String[] rotationInfo = reader.readLine().split(" ");
                int index = Integer.parseInt(rotationInfo[0]) - 1;
                int direction = Integer.parseInt(rotationInfo[1]); 
                propagateRotations(magnets, index, direction);
            }

            int score = calculateScore(magnets);
            output.append("#").append(t).append(" ").append(score).append("\n");
        }

        System.out.print(output);
        reader.close();
    }
}
