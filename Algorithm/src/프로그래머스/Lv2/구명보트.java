package 프로그래머스.Lv2;

import java.util.Arrays;

public class 구명보트 {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	static public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int min = 0, max = people.length - 1;
		while (min < max) {
			if (people[min] + people[max] <= limit) { // 두 명 탈출
				min += 1;
			}
			max -= 1;
			answer += 1;
		}
		if (min == max) { // 마지막 한 명
			answer += 1;
		}
		return answer;
	}

	static public int solution2(int[] people, int limit) {
		int answer = 0;
		boolean[] isEscape = new boolean[people.length];
		Arrays.sort(people);
		for (int i = people.length - 1; i >= 0; i--) { // 무게가 많이 나가는 사람부터 탈출시도
			if (!isEscape[i]) { // 이미 탈출했는지 확인
				for (int j = i - 1; j >= 0; j--) { // 같이 탈출할 사람 찾기
					if (!isEscape[j] && people[i] + people[j] <= limit) { // 아직 탈출하지 않았고 무게 합이 기준보다 작으면
						isEscape[j] = true; // 찾은 사람 같이 탈출
						break;
					}
				}
				isEscape[i] = true; // 탈출
				answer += 1; // 사용한 보트
			}
		}
		return answer;
	}
}
