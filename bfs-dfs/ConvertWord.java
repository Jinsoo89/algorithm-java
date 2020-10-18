import java.util.*;

class ConvertWord {

    public class Node {
        String word;
        int edge;

        public Node(String word, int edge) {
            this.word = word;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.word.equals(target)) {
                return node.edge;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && convertable(node.word, words[i])) {
                    queue.offer(new Node(words[i], node.edge + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    public boolean convertable(String str1, String str2) {
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        if (count > 1) {
            return false;
        }
        return true;
    }
}