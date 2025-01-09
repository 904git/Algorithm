package 프로그래머스.Lv0;

public class 팩토리얼 {
	public static void main(String[] args) {
		int n = 3628700;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 1;
		int nF = 1;
		while (true) {
			nF *= answer; // n!
			if (nF > n) { // nF!이 n보다 커지면 1빼고 리턴
				answer -= 1;
				break;
			} else if (nF == n) { // nF!이 n과 같으면 그대로 리턴
				break;
			}
			answer += 1;
		}
		return answer;
	}

}
