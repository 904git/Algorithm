package 프로그래머스.Lv2;

public class 다음큰숫자 {
	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = n + 1;
		while (n < answer) {
			if (oneCount(Integer.toBinaryString(n)) == oneCount(Integer.toBinaryString(answer))) { // 1의 개수가 같으면
				break;
			}
			answer += 1;
		}
		return answer;
	}

	static public int oneCount(String s) { // 2진수에서 1의 개수 카운트
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				cnt += 1;
			}
		}
		return cnt;
	}
}
