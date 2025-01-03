package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n의배수고르기 {
	public static void main(String[] args) {
		int n = 3;
		int[] numlist = { 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		System.out.println(Arrays.toString(solution(n, numlist)));
	}

	static public int[] solution(int n, int[] numlist) {
		List<Integer> list = new ArrayList<>(); // answer의 길이를 알 수 없으니 list 선언
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) { // n으로 나누어 떨어지면 삽입
				list.add(numlist[i]);
			}
		}
		int[] answer = new int[list.size()]; // 결과 배열 선언
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
