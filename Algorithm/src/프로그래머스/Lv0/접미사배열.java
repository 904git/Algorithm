package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 접미사배열 {
	public static void main(String[] args) {
		String my_string = "banana";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	static public String[] solution(String my_string) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < my_string.length(); i++) {
			list.add(my_string.substring(i)); // 앞에서 한글자씩 떼면서 삽입
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer); // 사전 순으로 정렬
		return answer;
	}
}
