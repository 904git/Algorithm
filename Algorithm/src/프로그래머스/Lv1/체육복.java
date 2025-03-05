package 프로그래머스.Lv1;

public class 체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 }, reserve = { 1, 3, 5 };
		System.out.println(solution(n, lost, reserve));
	}

	static public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] students = new int[n + 1];
		for (int i = 1; i <= n; i++) { // 모든 학생 기본 체육복
			students[i] += 1;
		}
		for (int i = 0; i < lost.length; i++) { // 체육복 잃어버린 학생
			students[lost[i]] -= 1;
		}
		for (int i = 0; i < reserve.length; i++) { // 여벌 체육복 있는 학생
			students[reserve[i]] += 1;
		}

		for (int i = 1; i <= n; i++) {
			if (0 < students[i]) { // 체육복 가지고 있으면
				answer += 1;
			} else { // 체육복 없으면
				// 옆 번호한테 빌리기
				if (1 <= i - 1 && 1 < students[i - 1]) {
					students[i - 1] -= 1;
					answer += 1;
				} else if (i + 1 <= n && 1 < students[i + 1]) {
					students[i + 1] -= 1;
					answer += 1;
				}
			}
		}
		return answer;
	}
}
