import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static final String line0 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static final String line1 = "\"재귀함수가 뭔가요?\"";
    private static final String line2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static final String line3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static final String line4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    private static final String underbar = "_".repeat(4);
    private static final String newLine = "\n";

    private static final String closingLine0 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static final String closingLine1 = "라고 답변하였지.";

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append(line0).append(newLine);
        repeat(N);
        System.out.append(sb);
    }

    private static void repeat(int n) {
        if (n == 0) {
            sb.append(underbar.repeat(N - n)).append(line1).append(newLine);
            sb.append(underbar.repeat(N - n)).append(closingLine0).append(newLine);
            sb.append(underbar.repeat(N - n)).append(closingLine1).append(newLine);
            return;
        }

        sb.append(underbar.repeat(N - n)).append(line1).append(newLine);
        sb.append(underbar.repeat(N - n)).append(line2).append(newLine);
        sb.append(underbar.repeat(N - n)).append(line3).append(newLine);
        sb.append(underbar.repeat(N - n)).append(line4).append(newLine);

        repeat(n - 1);

        sb.append(underbar.repeat(N - n)).append(closingLine1).append(newLine);
    }
}