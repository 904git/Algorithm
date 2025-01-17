package 프로그래머스.Lv2;

import java.util.Arrays;

public class 카펫 {
	public static void main(String[] args) {
		int brown = 10, yellow = 2;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	static public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		for (int i = 1; i <= Math.sqrt(yellow); i++) { // i는 노란색의 세로 길이 (가로가 더 길거나 같음)
			// 노란색 세로 길이가 i, 가로 길이가 (yellow / i)일 때 brown 개수가 같으면
			if (yellow % i == 0 && brown == ((i + 1) + (yellow / i + 1)) * 2) {
				answer[0] = yellow / i + 2; // 가로가 더 길게
				answer[1] = i + 2;
				break;
			}
		}
		return answer;
	}
}
