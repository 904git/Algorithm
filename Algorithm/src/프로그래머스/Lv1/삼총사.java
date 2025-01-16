package 프로그래머스.Lv1;

public class 삼총사 {
	static int count = 0;

	public static void main(String[] args) {
		int[] number = { -2, 3, 0, 2, -5 };
		System.out.println(solution(number));
	}

	static public int solution(int[] number) {
		int answer = 0;
		comb(number, 0, 0, 0);
		answer = count;
		return answer;
	}

	static public void comb(int[] number, int cur, int cnt, int sum) { // 3명의 학생을 선택하는 조합
		if (cnt == 3) { // 3명의 정수 번호를 합했을 때
			if (sum == 0) { // 합이 0이면
				count += 1;
			}
			return;
		}

		for (int i = cur; i < number.length; i++) {
			comb(number, i + 1, cnt + 1, sum + number[i]);
		}
	}
}
