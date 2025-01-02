package 프로그래머스.Lv0;

import java.util.Arrays;

public class 삼각형의완성조건1 {
	public static void main(String[] args) {
		int[] sides = { 1, 2, 3 };
		System.out.println(solution(sides));
	}

	static public int solution(int[] sides) {
		int answer = 0;
		Arrays.sort(sides); // 배열 정렬
		if (sides[2] < sides[0] + sides[1]) { // 가장 긴 변의 길이 < 나머지 두 변의 길이의 합
			answer = 1;
		} else {
			answer = 2;
		}
		return answer;
	}

}
