package 프로그래머스.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	static public int solution(String begin, String target, String[] words) {
		int answer = -1; // target 찾아도 +1 되므로 -1부터 시작
		boolean isPossible = false; // 단어 변환 가능성
		boolean[] visit = new boolean[words.length]; // 방문 확인
		Queue<String> queue = new LinkedList<>(); // BFS
		queue.add(begin);
		while (!queue.isEmpty() && !isPossible) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String now = queue.poll();
				if (now.equals(target)) { // target과 같아지면 반복문 종료
					isPossible = true;
					break;
				}
				for (int i = 0; i < words.length; i++) {
					int cnt = 0; // 서로 다른 알파벳 수
					if (!visit[i]) { // 아직 방문하지 않은 단어이면
						for (int j = 0; j < now.length(); j++) {
							if (now.charAt(j) != words[i].charAt(j)) {
								cnt += 1;
							}
						}
					}
					if (cnt == 1) { // 한 번에 한 개의 알파벳만 바꿀 수 있으므로 cnt가 1일 때 변경 가능
						visit[i] = true;
						queue.add(words[i]);
					}
				}
			}
			answer += 1; // 횟수 증가
		}
		if (!isPossible) { // 단어 변환이 불가능하면 0
			answer = 0;
		}
		return answer;
	}
}
