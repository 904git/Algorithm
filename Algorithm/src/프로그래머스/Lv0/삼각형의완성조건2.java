package 프로그래머스.Lv0;

import java.util.Arrays;

public class 삼각형의완성조건2 {
	public static void main(String[] args) {
		int[] sides = { 1, 2 };
		System.out.println(solution(sides));
	}

	static public int solution(int[] sides) {
		int answer = 0;
		for (int i = 1; i < sides[0] + sides[1]; i++) { // 가장 긴 변이 두 변의 합보다 작아야 함
			int[] triangle = { i, sides[0], sides[1] };
			Arrays.sort(triangle);
			if (triangle[2] < triangle[0] + triangle[1]) {
				answer += 1;
			}
		}
		return answer;
	}
}
