import java.util.*;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            int from = command[0];
            int to = command[1];
            int idx = command[2] - 1;

            int[] subArr = Arrays.copyOfRange(array, from - 1, to);
            Arrays.sort(subArr);

            answer[i] = subArr[idx];
        }

        return answer;
    }
}