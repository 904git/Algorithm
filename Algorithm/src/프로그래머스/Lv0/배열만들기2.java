package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기2 {
	public static void main(String[] args) {
		int l = 5, r = 555;
		System.out.println(Arrays.toString(solution(l, r)));
	}

	static public int[] solution(int l, int r) {
		List<Integer> list = new ArrayList<>();
		for (int n = l; n <= r; n++) {
			boolean check = true;
			for (int i = 1; i <= 9; i++) {
				if (i != 5 && Integer.toString(n).contains(Integer.toString(i))) { // 0과 5 이외의 숫자가 들어가는지 확인
					check = false;
					break;
				}
			}
			if (check) {
				list.add(n);
			}
		}
		int[] answer = { -1 };
		if (0 < list.size()) {
			answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}
}
