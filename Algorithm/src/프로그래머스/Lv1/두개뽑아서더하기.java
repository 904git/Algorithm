package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 두개뽑아서더하기 {
	static List<Integer> list;

	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	static public int[] solution(int[] numbers) {
		list = new ArrayList<>();
		comb(numbers, 0, 0, 0); // 두 개의 수를 뽑아 더해서 만들 수 있는 수 리스트
		Collections.sort(list); // 오름차순 정렬
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	static public void comb(int[] numbers, int cur, int cnt, int sum) { // 2개 선택해서 만들 수 있는 모든 수
		if (cnt == 2) {
			if (!list.contains(sum)) { // 만든 수가 아직 배열에 없으면 추가
				list.add(sum);
			}
			return;
		}

		for (int i = cur; i < numbers.length; i++) {
			comb(numbers, i + 1, cnt + 1, sum + numbers[i]);
		}
	}
}
