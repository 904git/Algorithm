package 프로그래머스.Lv0;

public class 양꼬치 {
	public static void main(String[] args) {
		int n = 10, k = 3;
		System.out.println(solution(n, k));
	}

	static public int solution(int n, int k) {
		int answer = n * 12000 + (k - n / 10) * 2000; // 서비스로 받은 음료수의 수 = n/10
		return answer;
	}

}
