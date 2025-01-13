package 프로그래머스.Lv0;

import java.util.Arrays;

public class 왼쪽오른쪽 {
	public static void main(String[] args) {
		String[] str_list = { "u", "u", "l", "r" };
		System.out.println(Arrays.toString(solution(str_list)));
	}

	static public String[] solution(String[] str_list) {
		String[] answer = {};
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].equals("l")) { // 왼쪽 배열
				answer = Arrays.copyOfRange(str_list, 0, i);
				break;
			} else if (str_list[i].equals("r")) { // 오른쪽 배열
				answer = Arrays.copyOfRange(str_list, i + 1, str_list.length);
				break;
			}
		}
		return answer;
	}
}
