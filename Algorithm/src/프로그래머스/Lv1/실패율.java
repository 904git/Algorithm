package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 실패율 {
	public static void main(String[] args) {
		int N = 4;
		int[] stages = { 1 };
		System.out.println(Arrays.toString(solution(N, stages)));
	}

	static public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		Arrays.sort(stages); // 스테이지 오름차순 정렬
		PriorityQueue<float[]> pq = new PriorityQueue<>(new MySort()); // 실패율 순으로 정렬
		float score;
		for (int stage = 1, idx = 0, nIdx = 0; stage <= N; stage++) { // idx: 이전 스테이지 도달한 사람 인덱스,
																		// nIdx: 현재 스테이지 도달한 사람 인덱스
			nIdx = idx;
			while (nIdx < stages.length && stages[nIdx] <= stage) {
				nIdx += 1;
			}
			// (nIdx - idx): 현재 스테이지까지 도달했지만 클리어 못한 사람 수,
			// (stages.length - idx): 현재 스테이지 도달한 사람 수
			if (stages.length - idx == 0) { // 스테이지에 도달한 사람이 없으면 실패율 0
				score = 0;
			} else {
				score = ((float) nIdx - idx) / (stages.length - idx);
			}
			pq.add(new float[] { stage, score });
			idx = nIdx;
		}
		for (int i = 0; !pq.isEmpty(); i++) {
			float[] stage = pq.poll();
			answer[i] = (int) stage[0];
		}
		return answer;
	}

	static class MySort implements Comparator<float[]> { // {스테이지 번호, 실패율} 실패율 내림차순, 실패율이 같으면 번호 오름차순

		@Override
		public int compare(float[] o1, float[] o2) {
			// TODO Auto-generated method stub
			if (o1[1] == o2[1]) {
				return Float.compare(o1[0], o2[0]);
			}
			return Float.compare(o2[1], o1[1]);
		}
	}
}
