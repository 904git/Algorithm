package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이중우선순위큐 {
	public static void main(String[] args) {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		System.out.println(Arrays.toString(solution(operations)));
	}

	static public int[] solution(String[] operations) {
		int[] answer = new int[2];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < operations.length; i++) {
			String[] str_split = operations[i].split(" ");
			if (str_split[0].equals("I")) { // 숫자 삽입
				int idx = findIdx(list, 0, list.size(), Integer.parseInt(str_split[1])); // 삽입할 위치
				list.add(idx, Integer.parseInt(str_split[1]));
			} else { // 삭제
				if (list.size() < 1) { // 빈 큐에서 데이터를 삭제하라는 연산일 경우 무시
					continue;
				}
				if (0 < Integer.parseInt(str_split[1])) { // 최댓값 삭제
					list.remove(list.size() - 1);
				} else { // 최솟값 삭제
					list.remove(0);
				}
			}
			System.out.println(list.toString());
		}

		if (0 < list.size()) { // 빈 큐가 아니면
			answer[0] = list.get(list.size() - 1);
			answer[1] = list.get(0);
		}
		return answer;
	}

	static public int findIdx(List<Integer> list, int left, int right, int num) { // 오른차순 리스트에서 num이 삽입될 인덱스 찾기
		if (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < num) {
				return findIdx(list, mid + 1, right, num);
			} else if (num < list.get(mid)) {
				return findIdx(list, left, mid, num);
			} else {
				return mid;
			}
		}
		return left;
	}
}
