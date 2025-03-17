package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 마법의엘리베이터 {
	public static void main(String[] args) {
		int storey = 2554;
		System.out.println(solution(storey));
	}

	static public int solution(int storey) {
		int answer = 0;
		while (0 < storey) {
			int num = storey % 10; // 끝자리부터 계산
			storey /= 10;
			if (num < 5) { // 5보다 작은 수는 -하는게 더 빠름
				answer += num;
			} else { // 5보다 큰 수는 +하는게 더 빠름
				answer += 10 - num;
				if (num == 5) { // 5일 때
					if (5 <= storey % 10) { // 다음 수가 5보다 크거나 같으면 +
						storey += 1;
					}
				} else if (0 < storey % 10) { // 받아올림수
					storey += 1;
				} else {
					answer += 1;
				}
			}
		}
		return answer;
	}

	static public int solution2(int storey) {
		int answer = 0;
		List<Integer> list = new ArrayList<>(); // 자릿수 저장
		while (0 < storey) {
			list.add(storey % 10);
			storey /= 10;
		}
		for (int i = 0; i < list.size(); i++) { // 끝자리부터 계산
			if (list.get(i) < 5) { // 5보다 작은 수는 -하는게 더 빠름
				answer += list.get(i);
			} else { // 5보다 큰 수는 +하는게 더 빠름
				answer += 10 - list.get(i);
				if (list.get(i) == 5) {// 5일 때
					if (i < list.size() - 1 && 5 <= list.get(i + 1)) { // 다음 수가 5보다 크거나 같으면 +
						int next = list.remove(i + 1);
						list.add(i + 1, next + 1);
					}
				} else if (i < list.size() - 1) { // 받아올림수
					int next = list.remove(i + 1);
					list.add(i + 1, next + 1);
				} else {
					answer += 1;
				}
			}
		}
		return answer;
	}
}
