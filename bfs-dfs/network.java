import java.util.*;

class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);

                answer++;
            }
        }
        return answer;
    }

    public void bfs(int[][] computers, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int j = 0; j < computers.length; j++) {
                if (visited[j] == false && computers[num][j] == 1 && num != j) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}