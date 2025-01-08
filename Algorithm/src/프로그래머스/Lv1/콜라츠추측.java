package 프로그래머스.Lv1;

public class 콜라츠추측 {
	public static void main(String[] args) {
		int n = 626331;
		System.out.println(solution(n));
	}

	static public int solution(int num) {
		int answer = 0;
		int cnt = 0; // 작업 횟수
		long temp = num; // 형 변환
		while (cnt < 500 && temp != 1) {
			cnt += 1;
			if (temp % 2 == 0) { // 짝수이면
				temp /= 2;
			} else { // 홀수이면
				temp = temp * 3 + 1;
			}
		}

		if (500 <= cnt) { // 작업 횟수가 500이상이면 -1
			answer = -1;
		} else { // 500미만이면 cnt
			answer = cnt;
		}
		return answer;
	}
}
