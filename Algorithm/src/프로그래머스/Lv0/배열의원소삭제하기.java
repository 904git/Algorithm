package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열의원소삭제하기 {
	public static void main(String[] args) {
		int[] arr = { 293, 1000, 395, 678, 94 };
		int[] delete_list = { 94, 777, 104, 1000, 1, 12 };
		System.out.println(Arrays.toString(solution(arr, delete_list)));
	}

	static public int[] solution(int[] arr, int[] delete_list) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			boolean isContains = false;
			for (int j = 0; j < delete_list.length; j++) {
				if (arr[i] == delete_list[j]) { // delete_list에 있는지 확인
					isContains = true;
					break;
				}
			}
			if (!isContains) { // delete_list에 없으면 리스트에 추가
				list.add(arr[i]);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
