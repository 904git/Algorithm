package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의전당1 {
	public static void main(String[] args) {
		int k = 3;
		int[] score = { 10, 100, 20, 150, 1, 100, 200 };
		System.out.println(Arrays.toString(solution(k, score)));
	}

	static public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		PriorityQueue<Integer> topK = new PriorityQueue<>(); // 명예의 전당
		for (int i = 0; i < score.length; i++) {
			if (topK.size() < k) { // 전당에 k명이 아직 안 올라갔으면
				topK.add(score[i]); // 현재 점수 올리기
			} else {
				if (topK.peek() < score[i]) { // 명예의 전당 최하점수가 지금 점수보다 낮으면
					topK.poll(); // 최하점수 내리기
					topK.add(score[i]); // 현재 점수 올리기
				}
			}
			answer[i] = topK.peek(); // 현재 명예의 전당에서 최하점수
		}
		return answer;
	}
}
